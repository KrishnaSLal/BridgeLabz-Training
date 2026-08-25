package com.fundoonotes.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendOtpEmail(String to, String otp) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject("Fundoo Notes - Password Reset OTP");

        message.setText(
            "Your Fundoo Notes password reset OTP is: "
            + otp
            + "\n\n"
            + "This OTP is valid for 5 minutes."
            + "\n\n"
            + "If you did not request a password reset, "
            + "please ignore this email."
        );

        mailSender.send(message);
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