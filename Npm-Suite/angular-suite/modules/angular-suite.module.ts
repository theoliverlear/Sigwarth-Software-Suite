import {NgModule} from "@angular/core";
import {CommonModule, NgOptimizedImage} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {services} from "../services/services";
import {RouterModule} from "@angular/router";

// Components
import {SsAnchorComponent} from "../components/elements/element-group-native/ss-anchor/ss-anchor.component";
import {SsButtonComponent} from "../components/elements/element-group-native/ss-button/ss-button.component";
import {SsFooterComponent} from "../components/elements/element-group-native/ss-footer/ss-footer.component";
import {SsHeadComponent} from "../components/elements/element-group-native/ss-head/ss-head.component";
import {SsImgComponent} from "../components/elements/element-group-native/ss-img/ss-img.component";
import {SsInputComponent} from "../components/elements/element-group-native/ss-input/ss-input.component";
import {SsParagraphComponent} from "../components/elements/element-group-native/ss-paragraph/ss-paragraph.component";
import {SsTitleComponent} from "../components/elements/element-group-native/ss-title/ss-title.component";
import {SubtitleComponent} from "../components/elements/element-group-text/subtitle/subtitle.component";

// Directives
import {UndraggableDirective} from "../directives/undraggable.directive";
import {UnoptimizedImageDirective} from "../directives/unoptimized-image.directive";

@NgModule({
    declarations: [
        // components
        SsAnchorComponent,
        SsButtonComponent,
        SsFooterComponent,
        SsHeadComponent,
        SsImgComponent,
        SsInputComponent,
        SsParagraphComponent,
        SsTitleComponent,
        SubtitleComponent,
        // directives
        UndraggableDirective,
        UnoptimizedImageDirective,
    ],
    imports: [
        CommonModule,
        FormsModule,
        NgOptimizedImage,
        HttpClientModule,
        RouterModule,
    ],
    providers: [
        ...services,
    ],
    exports: [
        // components
        SsAnchorComponent,
        SsButtonComponent,
        SsFooterComponent,
        SsHeadComponent,
        SsImgComponent,
        SsInputComponent,
        SsParagraphComponent,
        SsTitleComponent,
        SubtitleComponent,
        // directives
        UndraggableDirective,
        UnoptimizedImageDirective,
        // modules for consumers
        RouterModule
    ],
})
export class AngularSuiteModule {}