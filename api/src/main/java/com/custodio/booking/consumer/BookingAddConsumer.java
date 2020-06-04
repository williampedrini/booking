package com.custodio.booking.consumer;

import com.custodio.booking.event.BookingAddEvent;
import com.custodio.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Optional.ofNullable;

@Slf4j
@Component
@RequiredArgsConstructor
class BookingAddConsumer implements Consumer<BookingAddEvent> {
    private final BookingRepository bookingRepository;

    @Override
    @Transactional
    @RabbitListener(queues = "${queue.bookingAdd}")
    public void onEvent(final BookingAddEvent event) {
        log.info("Processing event {} with id {}.", event.getType().getValue(), event.getId());

        ofNullable(event.getBooking()).ifPresentOrElse(this.bookingRepository::save, () -> {
            throw new AmqpRejectAndDontRequeueException("The event body is mandatory.");
        });
    }
}
