package com.custodio.booking.enumerable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageHeader {
    EVENT_TYPE("eventType");
    private final String value;
}
