// subtitle.component.ts
import {Component, Input} from "@angular/core";
import { TagType } from "../../../../models/html/TagType";
import {CommonModule} from "@angular/common";

@Component({
    selector: 'subtitle',
    standalone: false,
    templateUrl: './subtitle.component.html',
    styleUrls: ['./subtitle.component.scss']
})
export class SubtitleComponent {
    @Input() tagType: TagType = TagType.H2;
    @Input() text: string;
    constructor() {

    }

    protected readonly TagType = TagType;
}
