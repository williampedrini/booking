import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NavbarComponent} from './navbar/navbar.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {MessageInterceptor} from './interceptors/MessageInterceptor';
import {MatMenuModule} from '@angular/material/menu';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {RouterModule} from '@angular/router';
import {MatButtonModule} from '@angular/material/button';
import {MatSnackBarModule} from '@angular/material/snack-bar';

@NgModule({
    declarations: [
        NavbarComponent
    ],
    imports: [
        CommonModule,
        HttpClientModule,
        MatButtonModule,
        MatMenuModule,
        MatToolbarModule,
        MatIconModule,
        MatSnackBarModule,
        RouterModule
    ],
    exports: [
        NavbarComponent
    ],
    providers: [{
        provide: HTTP_INTERCEPTORS,
        useClass: MessageInterceptor,
        multi: true
    }]
})
export class CoreModule {
}
