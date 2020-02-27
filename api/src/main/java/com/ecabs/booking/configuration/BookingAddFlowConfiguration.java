package com.ecabs.booking.configuration;

import com.ecabs.booking.enumerable.MessageHeader;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.ecabs.booking.enumerable.BookingEventType.ADD;

@Configuration
class BookingAddFlowConfiguration {

    @Bean
    Binding bookingAddBinding(final HeadersExchange bookingExchange, final Queue bookingAddQueue) {
        return BindingBuilder
                .bind(bookingAddQueue)
                .to(bookingExchange)
                .where(MessageHeader.EVENT_TYPE.getValue())
                .matches(ADD.getValue());
    }

    @Bean
    Queue bookingAddQueue(@Value("${queue.bookingAdd}") final String queue) {
        return new Queue(queue);
    }
}
