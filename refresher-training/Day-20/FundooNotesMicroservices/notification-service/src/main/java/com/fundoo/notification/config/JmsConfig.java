package com.fundoo.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import jakarta.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsConfig {

    public static final String REMINDER_EVENT_QUEUE =
            "fundoo.reminder.events";

    @Bean
    public JmsTemplate jmsTemplate(
            ConnectionFactory connectionFactory) {

        return new JmsTemplate(
                connectionFactory
        );
    }

    @Bean
    public DefaultJmsListenerContainerFactory
            jmsListenerContainerFactory(
                    ConnectionFactory connectionFactory) {

        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();

        factory.setConnectionFactory(
                connectionFactory
        );

        factory.setConcurrency("1-3");

        return factory;
    }
}