package com.ecbas.booking.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class TripWayPointDTO {
    @NotNull(message = "The last stop definition is mandatory.")
    private Boolean lastStop;
    @NotEmpty(message = "The locality is mandatory.")
    private String locality;
    @NotNull(message = "The latitude is mandatory.")
    private Double lat;
    @NotNull(message = "The longitude is mandatory.")
    private Double lng;
    @NotNull(message = "The trip way point time is mandatory.")
    private Instant tripWayPointTimestamp;
}
