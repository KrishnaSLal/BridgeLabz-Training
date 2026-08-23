package com.fundoonotes.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fundoonotes.dto.ReminderMessage;

@Component
public class ReminderMessageListener {

    private final NotificationService notificationService;

    public ReminderMessageListener(
            NotificationService notificationService) {

        this.notificationService =
                notificationService;
    }

    @JmsListener(
            destination = ReminderMessageProducer.REMINDER_QUEUE
    )
    public void receiveReminder(
            ReminderMessage message) {

        System.out.println(
                "JMS message received for: "
                        + message.getUserEmail()
        );

        notificationService.createNotification(
                message
        );
    }
}