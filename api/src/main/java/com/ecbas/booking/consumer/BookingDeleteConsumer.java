package com.ecbas.booking.consumer;

import com.ecbas.booking.event.BookingDeleteEvent;
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
class BookingDeleteConsumer implements Consumer<BookingDeleteEvent> {
    private final BookingRepository repository;

    @Override
    @Transactional
    @RabbitListener(queues = "${queue.bookingDelete}")
    public void onEvent(final BookingDeleteEvent event) {
        log.info("Processing event {} with id {}.", event.getType().getValue(), event.getId());

        this.repository.findById(event.getBookingId()).orElseThrow(() -> {
            var message = format("The Booking with id %s does not exist.", event.getBookingId());
            return new AmqpRejectAndDontRequeueException(message);
        });
        this.repository.deleteById(event.getBookingId());
    }
}
