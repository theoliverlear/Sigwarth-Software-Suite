// http-client.service.ts
import {inject, Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {
    HttpOptions,
    httpOptions,
    httpOptionsWithCredentials
} from "./httpProperties";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class HttpClientService<Send, Receive> {
    private _url: string;
    private _httpClient: HttpClient;

    constructor(url: string = '') {
        this._url = url;
        this._httpClient = inject(HttpClient);
    }

    get url(): string {
        return this._url;
    }

    set url(url: string) {
        this._url = url;
    }

    public get(customHttpOptions?: HttpOptions): Observable<Receive> {
        customHttpOptions = this.resolveHttpOptions(customHttpOptions);
        return this._httpClient.get<Receive>(this._url, customHttpOptions);
    }

    public post(payload: Send, includeCredentials: boolean = false, customHttpOptions?: HttpOptions): Observable<Receive> {
        customHttpOptions = this.resolveHttpOptions(customHttpOptions, includeCredentials);
        return this._httpClient.post<Receive>(this._url, payload, customHttpOptions);
    }

    public put(payload: Send, customHttpOptions?: HttpOptions): Observable<Receive> {
        customHttpOptions = this.resolveHttpOptions(customHttpOptions);
        return this._httpClient.put<Receive>(this._url, payload, customHttpOptions);
    }

    public delete(customHttpOptions?: HttpOptions): Observable<Receive> {
        customHttpOptions = this.resolveHttpOptions(customHttpOptions);
        return this._httpClient.delete<Receive>(this._url, customHttpOptions);
    }

    private resolveHttpOptions(customHttpOptions: HttpOptions, includeCredentials: boolean = false): HttpOptions {
        if (customHttpOptions === undefined) {
            if (includeCredentials) {
                customHttpOptions = httpOptionsWithCredentials;
            } else {
                customHttpOptions = httpOptions;
            }
        }
        return customHttpOptions;
    }
}