package com.custodio.booking.event;

import com.custodio.booking.enumerable.BookingEventType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static com.custodio.booking.enumerable.BookingEventType.DELETE;

@RequiredArgsConstructor
public class BookingDeleteEvent extends AbstractBookingEvent {
    @Getter
    private final UUID bookingId;

    @Override
    public BookingEventType getType() {
        return DELETE;
    }
}
