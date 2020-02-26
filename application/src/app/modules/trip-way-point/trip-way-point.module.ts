import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TripWayPointListComponent} from './trip-way-point-list/trip-way-point-list.component';
import {TripWayPointListDialogComponent} from './trip-way-point-list-dialog/trip-way-point-list-dialog.component';
import {TripWayPointRegisterDialogComponent} from './trip-way-point-register-dialog/trip-way-point-register-dialog.component';
import {MatTableModule} from '@angular/material/table';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {FormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatInputModule} from '@angular/material/input';

@NgModule({
    declarations: [
        TripWayPointListComponent,
        TripWayPointListDialogComponent,
        TripWayPointRegisterDialogComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        MatTableModule,
        MatDialogModule,
        MatButtonModule,
        MatFormFieldModule,
        MatCheckboxModule,
        MatInputModule
    ],
    exports: [
        TripWayPointListComponent,
        TripWayPointListDialogComponent,
        TripWayPointRegisterDialogComponent
    ]
})
export class TripWayPointModule {
}
