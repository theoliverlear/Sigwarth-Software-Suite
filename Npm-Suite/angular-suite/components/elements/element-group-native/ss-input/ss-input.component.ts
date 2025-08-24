// ss-input.component.ts 
import {
    Component,
    EventEmitter,
    HostListener,
    Input,
    Output
} from "@angular/core";
import {InputType} from "./models/InputType";

@Component({
    selector: 'ss-input',
    templateUrl: './ss-input.component.html',
    styleUrls: ['./ss-input.component.scss']
})
export class SsInputComponent {
    @Input() inputType: InputType;
    @Output() inputEvent: EventEmitter<string> = new EventEmitter<string>();
    constructor() {

    }

    @HostListener('input', ['$event.target.value'])
    onInput(value: string): void {
        this.inputEvent.emit(value);
    }

    isCheckbox(): boolean {
        return this.inputType === InputType.CHECKBOX;
    }
}
