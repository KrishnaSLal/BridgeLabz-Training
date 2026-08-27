package com.fundoo.notification.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fundoo.notification.config.JmsConfig;
import com.fundoo.notification.service.NotificationService;

@Service
public class ReminderJmsConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(
                    ReminderJmsConsumer.class
            );

    private final ObjectMapper objectMapper;

    private final NotificationService
            notificationService;

    public ReminderJmsConsumer(
            ObjectMapper objectMapper,
            NotificationService notificationService) {

        this.objectMapper = objectMapper;

        this.notificationService =
                notificationService;
    }

    @JmsListener(
            destination =
                    JmsConfig.REMINDER_EVENT_QUEUE
    )
    public void receiveMessage(
            String message) {

        try {

            ReminderJmsEvent event =
                    objectMapper.readValue(
                            message,
                            ReminderJmsEvent.class
                    );

            log.info(
                    "Reminder JMS message received: {}",
                    event
            );

            notificationService.processReminder(
                    event
            );

            log.info(
                    "Reminder notification processed successfully"
            );

        } catch (Exception exception) {

            log.error(
                    "Failed to process reminder JMS message: {}",
                    message,
                    exception
            );

            /*
             * Re-throw so JMS considers the
             * message processing unsuccessful.
             */

            throw new IllegalStateException(
                    "Failed to process reminder message",
                    exception
            );
        }
    }
}