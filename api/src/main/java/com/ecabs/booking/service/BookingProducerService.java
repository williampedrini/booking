package com.ecabs.booking.service;

import com.ecabs.booking.event.BookingEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Service;

import static com.ecabs.booking.enumerable.MessageHeader.EVENT_TYPE;

@Service
@RequiredArgsConstructor
class BookingProducerService {
    private final AmqpTemplate rabbitTemplate;

    void dispatch(final BookingEvent event) {
        final var messageProperties = new MessageProperties();
        messageProperties.setHeader(EVENT_TYPE.getValue(), event.getType().getValue());

        final var messageConverter = new SimpleMessageConverter();
        final var message = messageConverter.toMessage(event, messageProperties);
        this.rabbitTemplate.convertAndSend(message);
    }
}
