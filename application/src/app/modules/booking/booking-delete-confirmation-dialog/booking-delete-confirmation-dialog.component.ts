import {Component} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';

@Component({
    selector: 'app-booking-delete-confirmation-dialog',
    templateUrl: './booking-delete-confirmation-dialog.component.html',
    styleUrls: ['./booking-delete-confirmation-dialog.component.scss']
})
export class BookingDeleteConfirmationDialogComponent {

    constructor(private dialog: MatDialogRef<BookingDeleteConfirmationDialogComponent>) {
    }

    onCancelClick(): void {
        this.dialog.close(false);
    }

    onConfirmationClick(): void {
        this.dialog.close(true);
    }
}
