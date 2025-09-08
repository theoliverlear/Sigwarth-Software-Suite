// ss-paragraph.component.ts
import { Component, Input } from "@angular/core";
import { CommonModule } from "@angular/common";

@Component({
    selector: 'ss-paragraph',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './ss-paragraph.component.html',
    styleUrls: ['./ss-paragraph.component.scss']
})
export class SsParagraphComponent {
    @Input() text: string;
    constructor() {
        
    }
}
