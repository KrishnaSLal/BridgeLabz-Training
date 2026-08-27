package com.fundoo.notes.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXPORT_QUEUE =
            "fundoo.export.queue";

    public static final String EXPORT_EXCHANGE =
            "fundoo.export.exchange";

    public static final String EXPORT_ROUTING_KEY =
            "note.export";

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

    @Bean
    public Jackson2JsonMessageConverter
    messageConverter() {

        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate =
                new RabbitTemplate(
                        connectionFactory
                );

        rabbitTemplate.setMessageConverter(
                messageConverter()
        );

        return rabbitTemplate;
    }
}