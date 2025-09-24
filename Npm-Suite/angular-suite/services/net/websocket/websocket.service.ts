// websocket.service.ts
import {Injectable} from "@angular/core";
import {Observable, Subject, Subscription, shareReplay} from "rxjs";
import {webSocket, WebSocketSubject} from "rxjs/webSocket";

@Injectable({
    providedIn: 'root'
})
export class WebSocketService<Send, Receive> {
    private socket$: WebSocketSubject<Send> | undefined;
    private socketSub?: Subscription;

    private messagesSubject$: Subject<Receive> = new Subject<Receive>();
    public messages$: Observable<Receive> = this.messagesSubject$.asObservable().pipe(shareReplay(1));

    private _isConnected: boolean = false;
    private _url: string;
    private _withLogging: boolean;

    constructor(url: string, withLogging: boolean = false) {
        this._url = url;
        this._withLogging = withLogging;
    }

    public connect(): void {
        if (!this.isSocketUnavailable()) {
            return;
        }
        if (this._withLogging) {
            console.log('Connecting to WebSocket: ', this._url);
        }
        this.initializeSocket(this._url);
        this.subscribeToServer();
    }

    private isSocketUnavailable(): boolean {
        return !this.socket$ || this.socket$.closed === true;
    }

    private subscribeToServer(): void {
        if (!this.socket$) {
            return;
        }
        if (this._withLogging) {
            console.log('Subscribing to WebSocket');
        }
        this.socketSub = this.socket$.subscribe({
            next: (message: Send): void => this.messagesSubject$.next(message as unknown as Receive),
            error: (error: any): void => {
                console.error('WebSocket error:', error);
                this._isConnected = false;
            },
            complete: (): void => {
                this._isConnected = false;
            }
        });
    }

    private initializeSocket(url: string): void {
        this.socket$ = webSocket<Send>({
            url: url,
            serializer: (msg: Send) => JSON.stringify(msg),
            deserializer: (event: MessageEvent<any>) => JSON.parse(event.data) as Send,
            openObserver: {
                next: (): void => {
                    this._isConnected = true;
                }
            },
            closeObserver: {
                next: (): void => {
                    this._isConnected = false;
                }
            }
        });
    }

    public sendMessage(message: Send): void {
        if (this.canSendMessage()) {
            if (this._withLogging) {
                console.log('Sending message: ', message);
            }
            this.socket$!.next(message);
        } else {
            console.error('WebSocket is not connected.');
        }
    }

    private canSendMessage(): boolean {
        return !!this.socket$ && this.isConnected && !this.socket$.closed;
    }

    public disconnect(): void {
        this.closeConnection();
    }

    private closeConnection(): void {
        if (this._withLogging) {
            console.log('Closing WebSocket connection');
        }
        try {
            if (this.socketSub && !this.socketSub.closed) {
                this.socketSub.unsubscribe();
            }
            if (this.socket$ && !this.socket$.closed) {
                this.socket$.complete();
            }
        } finally {
            this._isConnected = false;
            this.socketSub = undefined;
            this.socket$ = undefined;
        }
    }

    public getMessages(): Observable<Receive> {
        return this.messages$;
    }

    get isConnected(): boolean {
        return this._isConnected;
    }

    get url(): string {
        return this._url;
    }
}