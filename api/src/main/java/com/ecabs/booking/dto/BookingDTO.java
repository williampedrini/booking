package com.ecabs.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
public class BookingDTO {
    private UUID bookingId;
    private String passengerName;
    private String passengerContactNumber;
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private OffsetDateTime pickupTime;
    private Boolean asap;
    private Integer waitingTime;
    private Integer noOfPassengers;
    private BigDecimal price;
    private Integer rating;
    private Instant createdOn;
    private Instant hasModifiedOn;
    private List<TripWayPointDTO> tripWayPoints;
}
