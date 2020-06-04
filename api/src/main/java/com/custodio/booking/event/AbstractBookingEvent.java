package com.custodio.booking.event;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

abstract class AbstractBookingEvent implements BookingEvent, Serializable {
    @Getter
    private final UUID id;

    AbstractBookingEvent() {
        this.id = UUID.randomUUID();
    }
}
