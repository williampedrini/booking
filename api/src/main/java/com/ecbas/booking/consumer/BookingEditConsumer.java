package com.ecbas.booking.consumer;

import com.ecbas.booking.event.BookingEditEvent;
import com.ecbas.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;

@Slf4j
@Component
@RequiredArgsConstructor
class BookingEditConsumer implements Consumer<BookingEditEvent> {
    private final BookingRepository repository;

    @Override
    @Transactional
    @RabbitListener(queues = "${queue.bookingEdit}")
    public void onEvent(final BookingEditEvent event) {
        log.info("Processing event {} with id {}.", event.getType().getValue(), event.getId());

        var booking = event.getBooking();
        var bookingToUpdate = this.repository.findById(booking.getBookingId()).orElseThrow(() -> {
            var message = format("The Booking with id %s does not exist.", booking.getBookingId());
            return new AmqpRejectAndDontRequeueException(message);
        });

        booking.setCreatedOn(bookingToUpdate.getCreatedOn());
        this.repository.save(booking);
    }
}
