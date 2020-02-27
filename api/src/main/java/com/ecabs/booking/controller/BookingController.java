package com.ecabs.booking.controller;

import com.ecabs.booking.dto.BookingAddRequestDTO;
import com.ecabs.booking.dto.BookingDTO;
import com.ecabs.booking.dto.BookingEditRequestDTO;
import com.ecabs.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
class BookingController {
    private final BookingService defaultBookingService;

    @GetMapping
    Collection<BookingDTO> findAll() {
        return this.defaultBookingService.findAll();
    }

    @GetMapping("/{id}")
    BookingDTO findById(@PathVariable final UUID id) {
        return this.defaultBookingService.findById(id);
    }

    @PostMapping
    @ResponseStatus(ACCEPTED)
    UUID add(@Valid @RequestBody final BookingAddRequestDTO booking) {
        return this.defaultBookingService.add(booking);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    UUID edit(@PathVariable final UUID id, @Valid @RequestBody final BookingEditRequestDTO booking) {
        return this.defaultBookingService.edit(id, booking);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    UUID delete(@PathVariable final UUID id) {
        return this.defaultBookingService.deleteById(id);
    }
}
