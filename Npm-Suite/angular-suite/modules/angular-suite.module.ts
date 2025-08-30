import {NgModule} from "@angular/core";
import {elements} from "../components/elements/elements";
import {directives} from "../directives/directives";
import {CommonModule, NgOptimizedImage} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {HttpClientModule, provideHttpClient, withFetch} from "@angular/common/http";
import {services} from "../services/services";
import {AppRouting} from "./routing/app-routing.module";

@NgModule({
    declarations: [
    ],
    imports: [
        CommonModule,
        FormsModule,
        NgOptimizedImage,
        HttpClientModule,
        ...elements,
        ...directives,
    ],
    providers: [
        ...services,
        provideHttpClient(withFetch()),
    ],
    exports: [
        ...elements,
        ...directives,
        NgOptimizedImage,
        AppRouting
    ],
})
export class AngularSuiteModule {}