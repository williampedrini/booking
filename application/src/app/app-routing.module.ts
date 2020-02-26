import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BookingListComponent} from './modules/booking/booking-list/booking-list.component';
import {BookingRegisterComponent} from './modules/booking/booking-register/booking-register.component';

const routes: Routes = [
    {path: '', component: BookingListComponent},
    {path: 'bookings', component: BookingRegisterComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
