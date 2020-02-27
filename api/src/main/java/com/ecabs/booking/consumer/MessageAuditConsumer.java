package com.ecabs.booking.consumer;

import com.ecabs.booking.event.BookingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class MessageAuditConsumer implements Consumer<BookingEvent> {

    @Override
    @RabbitListener(queues = "${queue.audit}")
    public void onEvent(final BookingEvent event) {
        log.info("Auditing event with id {} and type {}.", event.getId(), event.getType().getValue());
    }
}
