package com.ecbas.booking.consumer;

import com.ecbas.booking.event.BookingEvent;

/**
 * Handles a specific event defined by the type associated to the handler.
 *
 * @param <T> The type of the event to be handled.
 */
interface Consumer<T extends BookingEvent> {

    /**
     * Performs business logic associated to a specific {@link BookingEvent}.
     *
     * @param event The event to be handled.
     */
    void onEvent(T event);
}
