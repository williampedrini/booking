package com.ecbas.booking.consumer;

import com.ecbas.booking.event.BookingAddEvent;
import com.ecbas.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        this.bookingRepository.save(event.getBooking());
    }
}
