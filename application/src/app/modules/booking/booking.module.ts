import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BookingDeleteConfirmationDialogComponent} from './booking-delete-confirmation-dialog/booking-delete-confirmation-dialog.component';
import {BookingListComponent} from './booking-list/booking-list.component';
import {BookingRegisterComponent} from './booking-register/booking-register.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatNativeDateModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatBottomSheetModule} from '@angular/material/bottom-sheet';
import {MatDialogModule} from '@angular/material/dialog';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TripWayPointModule} from '../trip-way-point/trip-way-point.module';

@NgModule({
    declarations: [
        BookingDeleteConfirmationDialogComponent,
        BookingListComponent,
        BookingRegisterComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        MatFormFieldModule,
        MatDatepickerModule,
        MatCheckboxModule,
        MatNativeDateModule,
        MatInputModule,
        MatTableModule,
        MatButtonModule,
        MatBottomSheetModule,
        MatDialogModule,
        RouterModule,
        TripWayPointModule
    ],
    exports: [
        BookingListComponent,
        BookingRegisterComponent
    ]
})
export class BookingModule {
}
