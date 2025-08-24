import {EmailValidatorService} from "./client/field/email-validator.service";
import {FilledFieldsService} from "./client/field/filled-fields.service";
import {PasswordMatchService} from "./client/field/password-match.service";
import {HashPasswordService} from "./client/password/hash-password.service";
import {DelayService} from "./client/delay.service";
import {HttpClientService} from "./net/http/http-client.service";
import {WebSocketService} from "./net/websocket/websocket.service";

export const services = [
    EmailValidatorService,
    FilledFieldsService,
    PasswordMatchService,
    HashPasswordService,
    DelayService,
    HttpClientService,
    WebSocketService
];