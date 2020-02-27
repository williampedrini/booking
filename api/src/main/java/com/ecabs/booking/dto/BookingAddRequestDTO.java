package com.ecabs.booking.dto;

import com.ecabs.booking.validator.OffsetDateTimeAfterOrEqualNow;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class BookingAddRequestDTO {
    @NotEmpty(message = "The passenger name is mandatory.")
    private String passengerName;

    @NotEmpty(message = "The passenger contact number is mandatory.")
    private String passengerContactNumber;

    @OffsetDateTimeAfterOrEqualNow(message = "The pickup time cannot be in the past.")
    @NotNull(message = "The pickup time is mandatory.")
    private OffsetDateTime pickupTime;

    @NotNull(message = "The definition of asap is mandatory.")
    private Boolean asap;

    @NotNull(message = "The waiting time is mandatory.")
    private Integer waitingTime;

    @NotNull(message = "The number of passengers is mandatory.")
    private Integer noOfPassengers;

    @NotNull(message = "The price is mandatory.")
    private BigDecimal price;

    @NotNull(message = "The rating is mandatory.")
    private Integer rating;

    @NotEmpty(message = "At least one trip way point is mandatory.")
    private List<TripWayPointDTO> tripWayPoints;
}
