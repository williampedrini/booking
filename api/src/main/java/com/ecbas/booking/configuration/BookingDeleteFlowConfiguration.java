package com.ecbas.booking.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.ecbas.booking.enumerable.BookingEventType.DELETE;
import static com.ecbas.booking.enumerable.MessageHeader.EVENT_TYPE;

@Configuration
class BookingDeleteFlowConfiguration {

    @Bean
    Binding bookingDeleteBinding(final HeadersExchange bookingExchange, final Queue bookingDeleteQueue) {
        return BindingBuilder
                .bind(bookingDeleteQueue)
                .to(bookingExchange)
                .where(EVENT_TYPE.getValue())
                .matches(DELETE.getValue());
    }

    @Bean
    Queue bookingDeleteQueue(@Value("${queue.bookingDelete}") final String queue) {
        return new Queue(queue);
    }
}
