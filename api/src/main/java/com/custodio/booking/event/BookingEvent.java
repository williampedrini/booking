package com.custodio.booking.event;

import com.custodio.booking.enumerable.BookingEventType;

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
