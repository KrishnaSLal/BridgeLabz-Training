package com.fundoonotes.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fundoonotes.dto.ReminderMessage;

@Service
public class ReminderMessageProducer {

    public static final String REMINDER_QUEUE =
            "fundoo.reminder.queue";

    private final JmsTemplate jmsTemplate;

    public ReminderMessageProducer(
            JmsTemplate jmsTemplate) {

        this.jmsTemplate = jmsTemplate;
    }

    public void sendReminder(
            ReminderMessage reminderMessage) {

        jmsTemplate.convertAndSend(
                REMINDER_QUEUE,
                reminderMessage
        );
    }
}