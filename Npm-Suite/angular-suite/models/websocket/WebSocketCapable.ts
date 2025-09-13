import {Subscription} from "rxjs";

export interface WebSocketCapable {
    webSocketSubscriptions: Record<string, Subscription>;
    initializeWebSockets(): void;
}