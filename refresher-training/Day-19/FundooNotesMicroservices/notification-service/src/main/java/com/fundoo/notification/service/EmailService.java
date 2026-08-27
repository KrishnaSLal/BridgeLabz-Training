package com.fundoo.notification.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(
            JavaMailSender mailSender) {

        this.mailSender = mailSender;
    }

    public void sendReminderEmail(
            String to,
            String reminderMessage) {

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo(to);

        message.setSubject(
                "Fundoo Notes - Reminder"
        );

        message.setText(
                "Hello,\n\n"
                + "This is your Fundoo Notes reminder.\n\n"
                + "Reminder:\n"
                + reminderMessage
                + "\n\n"
                + "Regards,\n"
                + "Fundoo Notes"
        );

        mailSender.send(message);
    }
}