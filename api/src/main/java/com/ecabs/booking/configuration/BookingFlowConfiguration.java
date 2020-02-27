package com.ecabs.booking.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingFlowConfiguration {

    @Bean
    Binding bookingExchangeBinding(final FanoutExchange messageExchange, final HeadersExchange bookingExchange) {
        return BindingBuilder
                .bind(bookingExchange)
                .to(messageExchange);
    }

    @Bean
    FanoutExchange messageExchange(@Value("${exchange.messageExchange}") final String exchangeName) {
        return new FanoutExchange(exchangeName);
    }

    @Bean
    HeadersExchange bookingExchange(@Value("${exchange.bookingExchange}") final String exchangeName) {
        return new HeadersExchange(exchangeName);
    }
}
