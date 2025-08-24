import {
    Component, HostBinding, HostListener,
    Input, OnInit
} from "@angular/core";
import {TagType} from "../../../../models/html/TagType";
import {Router} from "@angular/router";
import {CommonModule} from "@angular/common";
import {ElementLink} from "../../../../models/link/ElementLink";
import {TextElementLink} from "../../../../models/link/TextElementLink";

@Component({
    selector: 'ss-anchor',
    standalone: true,
    imports: [
        CommonModule
    ],
    templateUrl: './ss-anchor.component.html',
    styleUrls: ['./ss-anchor.component.scss']
})
export class SsAnchorComponent implements OnInit {
    @Input() elementLink: TextElementLink | ElementLink;
    hasText: boolean = false;
    displayText: string = '';
    displayTagType: TagType = TagType.SPAN;
    @Input() isButton: boolean = false;
    @HostBinding('class.link-button') get isButtonClass(): boolean {
        return this.isButton;
    }

    constructor(private router: Router) {
        
    }
    ngOnInit() {
        this.hasText = this.elementLink instanceof TextElementLink;
        if (this.elementLink instanceof TextElementLink) {
            this.displayText = this.elementLink.text;
            this.displayTagType = (this.elementLink as TextElementLink).tagType ?? TagType.SPAN;
        } else {
            this.displayText = '';
            this.displayTagType = TagType.SPAN;
        }
    }
    @HostListener('click', ['$event'])
    onClick() {
        if (this.isExternalLink(this.elementLink.hrefLink)) {
            event.preventDefault();
            window.open(this.elementLink.hrefLink, this.elementLink.targetType);
        } else {
            this.router.navigate([this.elementLink.hrefLink]);
        }
    }
    isExternalLink(href: string): boolean {
        return href.startsWith('http://') ||
            href.startsWith('https://') ||
            href.startsWith('//');
    }
    protected readonly TagType = TagType;
}