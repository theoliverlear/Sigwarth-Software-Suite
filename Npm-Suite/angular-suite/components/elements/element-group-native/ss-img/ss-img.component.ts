import {
    AfterViewInit,
    ChangeDetectorRef,
    Component,
    ElementRef,
    Input,
    ViewChild
} from "@angular/core";
import {ImageAsset} from "../../../../assets/ImageAsset";
import {CommonModule, NgOptimizedImage} from "@angular/common";
import {UndraggableDirective} from "../../../../directives/undraggable.directive";
import {UnoptimizedImageDirective} from "../../../../directives/unoptimized-image.directive";


@Component({
    selector: 'ss-img',
    standalone: true,
    imports: [
        CommonModule,
        NgOptimizedImage,
        UndraggableDirective,
        UnoptimizedImageDirective
    ],
    templateUrl: './ss-img.component.html',
    styleUrls: ['./ss-img.component.scss']
})
export class SsImgComponent implements AfterViewInit {
    @Input() imageAsset: ImageAsset;
    @Input() childId: string;
    @Input() childClass: string;
    @ViewChild('imageElement') imageElement: ElementRef;
    constructor(private changeDetector: ChangeDetectorRef) {
        
    }
    ngAfterViewInit() {
        if (this.imageAsset.src === '') {

        }
        this.changeDetector.detectChanges();
    }
    addClassToImageElement(className: string) {
        this.imageElement.nativeElement.classList.add(className);
    }
}