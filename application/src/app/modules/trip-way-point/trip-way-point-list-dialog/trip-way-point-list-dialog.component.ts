import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import TripWayPoint from '../../../core/models/TripWayPoint';

@Component({
    selector: 'app-trip-way-point-list-dialog',
    templateUrl: './trip-way-point-list-dialog.component.html',
    styleUrls: ['./trip-way-point-list-dialog.component.scss']
})
export class TripWayPointListDialogComponent {

    constructor(
        public dialogRef: MatDialogRef<TripWayPointListDialogComponent>,
        @Inject(MAT_DIALOG_DATA) public tripWayPoints: TripWayPoint[]) {
    }

    onCloseClick(): void {
        this.dialogRef.close();
    }
}
