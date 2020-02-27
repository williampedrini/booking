package com.ecabs.booking.event;

import com.ecabs.booking.enumerable.BookingEventType;
import com.ecabs.booking.model.Booking;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.ecabs.booking.enumerable.BookingEventType.ADD;

@RequiredArgsConstructor
public class BookingAddEvent extends AbstractBookingEvent {
    @Getter
    private final Booking booking;

    @Override
    public BookingEventType getType() {
        return ADD;
    }
}