package com.ecbas.booking.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class TripWayPoint implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "TRIP_WAY_POINT_ID", nullable = false)
    private UUID tripWayPointId;

    @ManyToOne
    @JoinColumn(name = "BOOKING_ID")
    private Booking booking;

    @Column(name = "LAST_STOP", nullable = false)
    private Boolean lastStop;

    @Column(name = "LOCALITY", nullable = false)
    private String locality;

    @Column(name = "LAT", nullable = false)
    private Double lat;

    @Column(name = "LNG", nullable = false)
    private Double lng;

    @Column(name = "TRIP_WAY_POINT_TIMESTAMP", nullable = false)
    private Instant tripWayPointTimestamp;
}
