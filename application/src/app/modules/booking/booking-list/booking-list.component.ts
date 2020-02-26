import {Component, OnInit} from '@angular/core';
import {BookingDeleteConfirmationDialogComponent} from '../booking-delete-confirmation-dialog/booking-delete-confirmation-dialog.component';
import Booking from '../../../core/models/Booking';
import {TripWayPointListDialogComponent} from '../../trip-way-point/trip-way-point-list-dialog/trip-way-point-list-dialog.component';
import TripWayPoint from '../../../core/models/TripWayPoint';
import {MessageService} from '../../../core/services/message/message.service';
import {BookingService} from '../../../core/services/booking/booking.service';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';

@Component({
    selector: 'app-booking-list',
    templateUrl: './booking-list.component.html',
    styleUrls: ['./booking-list.component.scss'],
    providers: [BookingService]
})
export class BookingListComponent implements OnInit {

    public displayedColumns: string[] = [
        'index',
        'passengerName',
        'passengerContactNumber',
        'pickupTime',
        'waitingTime',
        'noOfPassengers',
        'price',
        'rating',
        'createdOn',
        'hasModifiedOn',
        'editAction',
        'deleteAction',
        'tipWayPointViewAction'
    ];

    public bookings: Booking[] = [];

    constructor(private dialog: MatDialog, private router: Router,
                private bookingService: BookingService,
                private messageService: MessageService) {
    }

    ngOnInit() {
        this.bookingService.findAll().subscribe(bookings => this.bookings = bookings);
    }

    onEditClick(booking: Booking): void {
        this.router.navigate(['bookings'], {
            state: booking
        });
    }

    openDeleteDialog(id: string, index: number): void {
        const dialog = this.dialog.open(BookingDeleteConfirmationDialogComponent);

        dialog.afterClosed().subscribe((isBookingToDelete: boolean) => {
            if (isBookingToDelete) {
                this.bookingService.deleteById(id).subscribe(() => {
                    this.messageService.success('Booking Successfully Deleted.');
                    this.bookings.splice(index, 1);
                    this.bookings = [...this.bookings];
                });
            }
        });
    }

    openTripWayPointDialog(tripWayPoints: TripWayPoint[]): void {
        this.dialog.open(TripWayPointListDialogComponent, {
            data: tripWayPoints
        });
    }
}
