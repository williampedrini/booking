package com.custodio.booking.service;

import com.custodio.booking.dto.BookingAddRequestDTO;
import com.custodio.booking.dto.BookingDTO;
import com.custodio.booking.dto.BookingEditRequestDTO;
import com.custodio.booking.event.BookingAddEvent;
import com.custodio.booking.event.BookingDeleteEvent;
import com.custodio.booking.event.BookingEditEvent;
import com.custodio.booking.model.Booking;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.UUID;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
class DefaultBookingService implements BookingService {
    private final MapperFacade mapper;
    private final BookingProducerService producer;
    private final JpaRepository<Booking, UUID> repository;

    @Override
    public Collection<BookingDTO> findAll() {
        var bookings = this.repository.findAll();
        return this.mapper.mapAsList(bookings, BookingDTO.class);
    }

    @Override
    public BookingDTO findById(final UUID id) {
        return this.repository.findById(id)
                .map(booking -> this.mapper.map(booking, BookingDTO.class))
                .orElseThrow(() -> {
                    var message = format("There is no booking for the id %s", id);
                    return new NoResultException(message);
                });
    }

    @Override
    public UUID add(final BookingAddRequestDTO request) {
        var booking = this.mapper.map(request, Booking.class);
        var event = new BookingAddEvent(booking);
        this.producer.dispatch(event);
        return event.getId();
    }

    @Override
    public UUID edit(final UUID id, final BookingEditRequestDTO request) {
        var booking = this.mapper.map(request, Booking.class);
        booking.setBookingId(id);
        var event = new BookingEditEvent(booking);
        this.producer.dispatch(event);
        return event.getId();
    }

    @Override
    public UUID deleteById(final UUID id) {
        var event = new BookingDeleteEvent(id);
        this.producer.dispatch(event);
        return event.getId();
    }
}
