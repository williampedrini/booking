import {Component, Input} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import TripWayPoint from '../../../core/models/TripWayPoint';

@Component({
    selector: 'app-trip-way-point-register-dialog',
    templateUrl: './trip-way-point-register-dialog.component.html',
    styleUrls: ['./trip-way-point-register-dialog.component.scss']
})
export class TripWayPointRegisterDialogComponent {

    @Input()
    public tripWayPoint: TripWayPoint = new TripWayPoint();

    constructor(private dialog: MatDialogRef<TripWayPointRegisterDialogComponent>) {
    }

    onCancelClick(): void {
        this.dialog.close();
    }

    onConfirmationClick(): void {
        this.tripWayPoint.tripWayPointTimestamp = new Date(this.tripWayPoint.tripWayPointTimestamp);
        this.dialog.close(this.tripWayPoint);
    }

}
