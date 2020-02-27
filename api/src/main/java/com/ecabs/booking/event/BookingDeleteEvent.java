package com.ecabs.booking.event;

import com.ecabs.booking.enumerable.BookingEventType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static com.ecabs.booking.enumerable.BookingEventType.DELETE;

@RequiredArgsConstructor
public class BookingDeleteEvent extends AbstractBookingEvent {
    @Getter
    private final UUID bookingId;

    @Override
    public BookingEventType getType() {
        return DELETE;
    }
}
