package com.custodio.booking.event;

import com.custodio.booking.enumerable.BookingEventType;
import com.custodio.booking.model.Booking;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.custodio.booking.enumerable.BookingEventType.EDIT;

@RequiredArgsConstructor
public class BookingEditEvent extends AbstractBookingEvent {
    @Getter
    private final Booking booking;

    @Override
    public BookingEventType getType() {
        return EDIT;
    }
}
