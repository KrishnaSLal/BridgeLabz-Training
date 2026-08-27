package com.fundoo.notification.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.notification.dto.NotificationResponse;
import com.fundoo.notification.entity.Notification;
import com.fundoo.notification.messaging.ReminderJmsEvent;
import com.fundoo.notification.repository.NotificationRepository;

@Service
public class NotificationServiceImpl
        implements NotificationService {

    private final NotificationRepository
            notificationRepository;

    private final EmailService emailService;

    public NotificationServiceImpl(
            NotificationRepository notificationRepository,
            EmailService emailService) {

        this.notificationRepository =
                notificationRepository;

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

        Notification saved =
                notificationRepository.save(
                        notification
                );

        try {

            emailService.sendReminderEmail(
                    event.getEmail(),
                    event.getMessage()
            );

            saved.setEmailSent(true);

            notificationRepository.save(
                    saved
            );

        } catch (Exception exception) {

            saved.setEmailSent(false);

            notificationRepository.save(
                    saved
            );

            throw exception;
        }
    }

    @Override
    public List<NotificationResponse>
    getMyNotifications(
            String email) {

        /*
         * We don't keep a User entity in this
         * microservice. The authenticated email
         * comes from the JWT.
         *
         * Therefore retrieve notifications
         * directly by email.
         */

        return notificationRepository
                .findAll()
                .stream()
                .filter(notification ->
                        notification
                                .getEmail()
                                .equalsIgnoreCase(email)
                )
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