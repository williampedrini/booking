import {Injectable} from '@angular/core';
import Booking from '../../models/Booking';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import BookingAddRequest from '../../models/BookingAddRequest';
import ErrorResponse from '../../models/ResponseError';
import BookingEditRequest from '../../models/BookingEditRequest';
import {environment} from '../../../../environments/environment';

@Injectable()
export class BookingService {
    private static BASE_URL = environment.bookingApiBaseUrl + '/bookings';

    constructor(private http: HttpClient) {
    }

    public findAll(): Observable<Booking[]> {
        return this.http.get<Booking[]>(BookingService.BASE_URL);
    }

    public add(booking: Booking): Observable<string | ErrorResponse> {
        const payload: BookingAddRequest = new BookingAddRequest(
            booking.passengerName,
            booking.passengerContactNumber,
            new Date(booking.pickupTime),
            booking.asap,
            booking.waitingTime,
            booking.noOfPassengers,
            booking.price,
            booking.rating,
            booking.tripWayPoints
        );
        return this.http.post<string>(BookingService.BASE_URL, JSON.stringify(payload), {
            headers: new HttpHeaders().set('Content-Type', 'application/json')
        });
    }

    public edit(booking: Booking): Observable<string | ErrorResponse> {
        const payload: BookingEditRequest = new BookingEditRequest(
            booking.passengerName,
            booking.passengerContactNumber,
            new Date(booking.pickupTime),
            booking.asap,
            booking.waitingTime,
            booking.noOfPassengers,
            booking.price,
            booking.rating,
            booking.tripWayPoints
        );
        return this.http.put<string>(BookingService.BASE_URL + '/' + booking.bookingId, JSON.stringify(payload), {
            headers: new HttpHeaders().set('Content-Type', 'application/json')
        });
    }

    public deleteById(id: string): Observable<string | ErrorResponse> {
        return this.http.delete<string>(BookingService.BASE_URL + '/' + id);
    }
}
