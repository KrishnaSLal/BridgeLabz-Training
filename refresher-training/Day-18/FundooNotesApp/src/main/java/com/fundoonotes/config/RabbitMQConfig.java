package com.fundoonotes.config;

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
            "fundoo.export.queue"; //name of the queue

    public static final String EXPORT_EXCHANGE =
            "fundoo.export.exchange"; //name of the exchange (receives the message from producer)

    public static final String EXPORT_ROUTING_KEY =
            "note.export"; //routing key helps to send message

    @Bean
    public Queue exportQueue() {
        return new Queue(EXPORT_QUEUE, true); //true is durable
    }

    @Bean
    public DirectExchange exportExchange() {
        return new DirectExchange(EXPORT_EXCHANGE);
    }

    
    // connects exchange and queue
    
    @Bean
    public Binding exportBinding(
            Queue exportQueue,
            DirectExchange exportExchange) {

        return BindingBuilder
                .bind(exportQueue)
                .to(exportExchange)
                .with(EXPORT_ROUTING_KEY);
    }

    //to convert Java objects to/from JSON
    
    @Bean 
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    
    // for communication
    
    @Bean
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate =
                new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(
                messageConverter()
        );

        return rabbitTemplate;
    }
}