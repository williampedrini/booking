package com.custodio.booking.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AuditFlowConfiguration {

    @Bean
    Binding auditQueueBinding(final FanoutExchange messageExchange, final Queue messageAuditQueue) {
        return BindingBuilder
                .bind(messageAuditQueue)
                .to(messageExchange);
    }

    @Bean
    Queue messageAuditQueue(@Value("${queue.audit}") final String queue) {
        return new Queue(queue);
    }
}
