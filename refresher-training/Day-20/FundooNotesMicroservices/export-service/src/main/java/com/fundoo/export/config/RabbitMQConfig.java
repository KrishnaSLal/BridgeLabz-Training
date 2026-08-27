package com.fundoo.export.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXPORT_QUEUE =
            "fundoo.export.queue";

    public static final String EXPORT_EXCHANGE =
            "fundoo.export.exchange";

    public static final String EXPORT_ROUTING_KEY =
            "fundoo.export";

    @Bean
    public Queue exportQueue() {

        return new Queue(
                EXPORT_QUEUE,
                true
        );
    }

    @Bean
    public DirectExchange exportExchange() {

        return new DirectExchange(
                EXPORT_EXCHANGE
        );
    }

    @Bean
    public Binding exportBinding(
            Queue exportQueue,
            DirectExchange exportExchange) {

        return BindingBuilder
                .bind(exportQueue)
                .to(exportExchange)
                .with(EXPORT_ROUTING_KEY);
    }
}