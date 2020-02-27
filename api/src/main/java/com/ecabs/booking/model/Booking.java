package com.ecabs.booking.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Booking implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "BOOKING_ID", nullable = false)
    private UUID bookingId;

    @Column(name = "PASSENGER_NAME", nullable = false)
    private String passengerName;

    @Column(name = "PASSENGER_CONTACT_NUMBER", nullable = false)
    private String passengerContactNumber;

    @Column(name = "PICKUP_TIME", nullable = false)
    private OffsetDateTime pickupTime;

    @Column(name = "ASAP", nullable = false)
    private Boolean asap;

    @Column(name = "WAITING_TIME", nullable = false)
    private Integer waitingTime;

    @Column(name = "NO_OF_PASSENGERS", nullable = false)
    private Integer noOfPassengers;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "RATING")
    private Integer rating;

    @CreatedDate
    @Column(name = "CREATED_ON", nullable = false)
    private Instant createdOn;

    @LastModifiedDate
    @Column(name = "HAS_MODIFIED_ON", nullable = false)
    private Instant hasModifiedOn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOKING_ID", referencedColumnName = "BOOKING_ID")
    private List<TripWayPoint> tripWayPoints;
}
