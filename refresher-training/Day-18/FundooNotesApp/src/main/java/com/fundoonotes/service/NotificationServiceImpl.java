package com.fundoonotes.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoonotes.dto.NotificationResponse;
import com.fundoonotes.entity.Notification;
import com.fundoonotes.entity.User;
import com.fundoonotes.messaging.ReminderJmsEvent;
import com.fundoonotes.repository.NotificationRepository;
import com.fundoonotes.repository.UserRepository;

@Service
public class NotificationServiceImpl
        implements NotificationService {

    private final NotificationRepository notificationRepository;

    private final UserRepository userRepository;

    private final EmailService emailService;

    public NotificationServiceImpl(
            NotificationRepository notificationRepository,
            UserRepository userRepository,
            EmailService emailService) {

        this.notificationRepository =
                notificationRepository;

        this.userRepository =
                userRepository;

        this.emailService =
                emailService;
    }

    @Override
    @Transactional
    public void processReminder(
            ReminderJmsEvent event) {

        Notification notification =
                new Notification();

        notification.setUserId(
                event.getUserId()
        );

        notification.setNoteId(
                event.getNoteId()
        );

        notification.setEmail(
                event.getEmail()
        );

        notification.setMessage(
                event.getMessage()
        );

        notification.setEmailSent(false);

        /*
         * Save notification first.
         */
        Notification saved =
                notificationRepository.save(
                        notification
                );

        try {

            /*
             * Send email using the existing
             * SMTP EmailService.
             */
            emailService.sendReminderEmail(
                    event.getEmail(),
                    event.getMessage()
            );

            saved.setEmailSent(true);

            notificationRepository.save(saved);

        } catch (Exception exception) {

            /*
             * Notification remains stored with
             * emailSent = false.
             */
            saved.setEmailSent(false);

            notificationRepository.save(saved);

            throw exception;
        }
    }

    @Override
    public List<NotificationResponse>
    getMyNotifications(String email) {

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "User not found"
                                )
                        );

        return notificationRepository
                .findByUserIdOrderByCreatedAtDesc(
                        user.getUserId()
                )
                .stream()
                .map(notification ->
                        new NotificationResponse(
                                notification
                                        .getNotificationId(),

                                notification
                                        .getNoteId(),

                                notification
                                        .getMessage(),

                                notification
                                        .isEmailSent(),

                                notification
                                        .getCreatedAt()
                        )
                )
                .toList();
    }
}