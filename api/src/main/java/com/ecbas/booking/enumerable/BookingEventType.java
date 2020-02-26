package com.ecbas.booking.enumerable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BookingEventType {
    ADD("bookingAdd"),
    DELETE("bookingDelete"),
    EDIT("bookingEdit");
    private final String value;
}
