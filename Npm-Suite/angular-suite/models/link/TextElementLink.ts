import { ElementLink } from "./ElementLink";
import { TargetType } from "../html/TargetType";
import {TagType} from "../html/TagType";

export class TextElementLink extends ElementLink {
    text: string;
    tagType: TagType;
    constructor(hrefLink: string = '',
                targetType: TargetType = TargetType.SELF,
                useHyperlinkStyle: boolean = false,
                text: string = '',
                tagType: TagType = TagType.P) {
        super(hrefLink, targetType, useHyperlinkStyle);
        this.text = text;
        this.tagType = tagType;
    }
    
    hasText(): boolean {
        return this.text.length > 0;
    }
}