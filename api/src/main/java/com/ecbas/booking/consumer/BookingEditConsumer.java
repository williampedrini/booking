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
import static java.util.Optional.ofNullable;

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

        ofNullable(event.getBooking())
                .ifPresentOrElse(booking ->
                                this.repository.findById(booking.getBookingId())
                                        .map(bookingToUpdate -> {
                                            booking.setCreatedOn(bookingToUpdate.getCreatedOn());
                                            return booking;
                                        })
                                        .ifPresentOrElse(this.repository::save, () -> {
                                            var message = format("The Booking with id %s does not exist.", booking.getBookingId());
                                            throw new AmqpRejectAndDontRequeueException(message);
                                        })
                        , () -> {
                            throw new AmqpRejectAndDontRequeueException("The event body is mandatory.");
                        });
    }
}
