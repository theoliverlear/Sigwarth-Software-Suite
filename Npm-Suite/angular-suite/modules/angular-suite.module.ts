import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {elements} from "../components/elements/elements";
import {directives} from "../directives/directives";
import {CommonModule, NgOptimizedImage} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {HttpClientModule, provideHttpClient, withFetch} from "@angular/common/http";
import {services} from "../services/services";
import {AppRouting} from "./routing/app-routing.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {RouterModule} from "@angular/router";

@NgModule({
    declarations: [
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        CommonModule,
        FormsModule,
        NgOptimizedImage,
        HttpClientModule,
        RouterModule,
        AppRouting,
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
        RouterModule,
        AppRouting
    ],
})
export class AngularSuiteModule {}