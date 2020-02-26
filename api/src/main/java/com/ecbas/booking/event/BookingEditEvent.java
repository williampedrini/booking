package com.ecbas.booking.event;

import com.ecbas.booking.enumerable.BookingEventType;
import com.ecbas.booking.model.Booking;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.ecbas.booking.enumerable.BookingEventType.EDIT;

@RequiredArgsConstructor
public class BookingEditEvent extends AbstractBookingEvent {
    @Getter
    private final Booking booking;

    @Override
    public BookingEventType getType() {
        return EDIT;
    }
}