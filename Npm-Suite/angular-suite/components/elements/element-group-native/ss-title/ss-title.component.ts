// ss-title.component.ts
import {Component, Input} from "@angular/core";
import {CommonModule} from "@angular/common";
import { TagType } from "../../../../models/html/TagType";

@Component({
    selector: 'ss-title',
    standalone: true,
    imports: [
        CommonModule
    ],
    templateUrl: './ss-title.component.html',
    styleUrls: ['./ss-title.component.scss']
})
export class SsTitleComponent {
    @Input() tagType: TagType = TagType.H1;
    @Input() text: string;
    constructor() {

    }

    protected readonly TagType = TagType;
}

