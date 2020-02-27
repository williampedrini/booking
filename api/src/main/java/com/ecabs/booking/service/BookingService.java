package com.ecabs.booking.service;

import com.ecabs.booking.dto.BookingAddRequestDTO;
import com.ecabs.booking.dto.BookingDTO;
import com.ecabs.booking.dto.BookingEditRequestDTO;

import java.util.Collection;
import java.util.UUID;

public interface BookingService {

    /**
     * Find all existing bookings into the database.
     *
     * @return All found bookings.
     */
    Collection<BookingDTO> findAll();

    /**
     * Search for a specific booking by its identifier.
     *
     * @param id The booking identifier.
     * @return The booking if found.
     */
    BookingDTO findById(UUID id);

    /**
     * Persist a booking into the database.
     *
     * @param request The booking to be persisted.
     * @return The id of the event responsible for the action.
     */
    UUID add(BookingAddRequestDTO request);

    /**
     * Update an already existing booking into the database.
     *
     * @param id      The booking identifier.
     * @param request The booking information to be edited.
     * @return The id of the event responsible for the action.
     */
    UUID edit(UUID id, BookingEditRequestDTO request);

    /**
     * Deletes a specific booking by its identifier.
     *
     * @return The id of the event responsible for the action.
     */
    UUID deleteById(UUID id);
}
