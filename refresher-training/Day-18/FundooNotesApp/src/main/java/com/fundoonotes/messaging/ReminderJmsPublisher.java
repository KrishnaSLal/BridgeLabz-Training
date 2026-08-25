package com.fundoonotes.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fundoonotes.config.JmsConfig;

@Service
public class ReminderJmsPublisher {

    private static final Logger log =
            LoggerFactory.getLogger(
                    ReminderJmsPublisher.class
            );

    private final JmsTemplate jmsTemplate;

    private final ObjectMapper objectMapper;

    public ReminderJmsPublisher(
            JmsTemplate jmsTemplate,
            ObjectMapper objectMapper) {

        this.jmsTemplate = jmsTemplate;

        this.objectMapper = objectMapper;
    }

    public void publish(
            ReminderJmsEvent event) {

        try {

            String json =
                    objectMapper.writeValueAsString(
                            event
                    );

            jmsTemplate.convertAndSend(
                    JmsConfig.REMINDER_EVENT_QUEUE,
                    json
            );

            log.info(
                    "Reminder JMS event published: {}",
                    json
            );

        } catch (JsonProcessingException exception) {

            log.error(
                    "Failed to serialize reminder JMS event",
                    exception
            );

            throw new IllegalStateException(
                    "Unable to publish reminder event",
                    exception
            );
        }
    }
}