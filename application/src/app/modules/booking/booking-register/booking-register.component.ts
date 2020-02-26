import {Component} from '@angular/core';
import {BookingService} from '../../../core/services/booking/booking.service';
import Booking from '../../../core/models/Booking';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {MessageService} from '../../../core/services/message/message.service';
import {TripWayPointRegisterDialogComponent} from '../../trip-way-point/trip-way-point-register-dialog/trip-way-point-register-dialog.component';

@Component({
    selector: 'app-booking-register',
    templateUrl: './booking-register.component.html',
    styleUrls: ['./booking-register.component.scss'],
    providers: [BookingService]
})
export class BookingRegisterComponent {

    public booking: Booking = new Booking();

    constructor(private dialog: MatDialog, private router: Router,
                private bookingService: BookingService, private messageService: MessageService) {
        this.booking = this.router.getCurrentNavigation().extras.state as Booking || new Booking();
    }

    onSaveClick(): void {
        if (this.booking.bookingId) {
            this.bookingService.edit(this.booking).subscribe(() => {
                this.messageService.success('Booking Successfully Updated.');
                this.router.navigate(['']);
            });
        } else {
            this.bookingService.add(this.booking).subscribe(() => {
                this.messageService.success('Booking Successfully Created.');
                this.router.navigate(['']);
            });
        }
    }

    onAddTripWayPointClick(event: Event): void {
        const dialog = this.dialog.open(TripWayPointRegisterDialogComponent);
        dialog.afterClosed().subscribe((tripWayPoint) => {
            if (tripWayPoint) {
                this.booking.tripWayPoints = [...this.booking.tripWayPoints, tripWayPoint];
            }
        });
        event.preventDefault();
    }
}
