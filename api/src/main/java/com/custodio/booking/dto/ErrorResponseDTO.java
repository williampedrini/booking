package com.custodio.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

public class ErrorResponseDTO {

    @JsonFormat(shape = STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;

    @JsonProperty
    private final List<String> messages;

    public ErrorResponseDTO(final Throwable throwable) {
        this.timestamp = LocalDateTime.now();
        this.messages = Optional.ofNullable(throwable)
                .map(Throwable::getMessage)
                .map(Arrays::asList)
                .orElseGet(ArrayList::new);
    }

    public ErrorResponseDTO(final List<String> messages) {
        this.timestamp = LocalDateTime.now();
        this.messages = Optional.ofNullable(messages)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public List<String> getMessages() {
        return new ArrayList<>(this.messages);
    }
}
