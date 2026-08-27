package com.fundoo.reminder.messaging;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fundoo.reminder.config.JmsConfig;

@Component
public class ReminderMessagePublisher {

    private final JmsTemplate jmsTemplate;

    private final ObjectMapper objectMapper;

    public ReminderMessagePublisher(
            JmsTemplate jmsTemplate,
            ObjectMapper objectMapper) {

        this.jmsTemplate = jmsTemplate;

        this.objectMapper = objectMapper;
    }

    public void sendReminder(
            ReminderJmsEvent event) {

        try {

            String json =
                    objectMapper.writeValueAsString(
                            event
                    );

            jmsTemplate.convertAndSend(
                    JmsConfig.REMINDER_QUEUE,
                    json
            );

        } catch (JsonProcessingException exception) {

            throw new IllegalStateException(
                    "Unable to publish reminder event",
                    exception
            );
        }
    }
}