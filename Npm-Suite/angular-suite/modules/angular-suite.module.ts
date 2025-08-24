import {NgModule} from "@angular/core";
import {elements} from "../components/elements/elements";
import {directives} from "../directives/directives";
import {CommonModule, NgOptimizedImage} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {HttpClientModule, provideHttpClient, withFetch} from "@angular/common/http";
import {services} from "../services/services";

@NgModule({
    declarations: [
        ...elements,
        ...directives,
    ],
    imports: [
        CommonModule,
        FormsModule,
        NgOptimizedImage,
        HttpClientModule,
    ],
    providers: [
        ...services,
        provideHttpClient(withFetch()),
    ],
    exports: [
        ...elements,
        ...directives,
        NgOptimizedImage
    ],
})
export class AngularSuiteModule {}