package com.ecbas.booking.event;

import com.ecbas.booking.enumerable.BookingEventType;

import java.util.UUID;

/**
 * Represents a booking event used to perform async actions over the application.
 */
public interface BookingEvent {

    /**
     * Retrieves the event number.
     *
     * @return The event number.
     */
    UUID getId();

    /**
     * Retrieved the type associated to the event.
     *
     * @return The event type.
     */
    BookingEventType getType();
}
