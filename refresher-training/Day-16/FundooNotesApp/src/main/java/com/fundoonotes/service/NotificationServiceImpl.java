package com.fundoonotes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoonotes.dto.NotificationResponse;
import com.fundoonotes.dto.ReminderMessage;
import com.fundoonotes.entity.Notification;
import com.fundoonotes.repository.NotificationRepository;

@Service
public class NotificationServiceImpl
        implements NotificationService {

    private final NotificationRepository
            notificationRepository;

    public NotificationServiceImpl(
            NotificationRepository notificationRepository) {

        this.notificationRepository =
                notificationRepository;
    }

    @Override
    public void createNotification(
            ReminderMessage message) {

        Notification notification =
                new Notification();

        notification.setNoteId(
                message.getNoteId()
        );

        notification.setUserEmail(
                message.getUserEmail()
        );

        notification.setMessage(
                message.getMessage()
        );

        notification.setCreatedAt(
                LocalDateTime.now()
        );

        notification.setReadStatus(false);

        notificationRepository.save(notification);

        System.out.println(
                "Notification created for: "
                        + message.getUserEmail()
        );
    }

    @Override
    public List<NotificationResponse>
            getMyNotifications(
                    String userEmail) {

        return notificationRepository
                .findByUserEmailOrderByCreatedAtDesc(
                        userEmail
                )
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<NotificationResponse>
            getUnreadNotifications(
                    String userEmail) {

        return notificationRepository
                .findByUserEmailAndReadStatusFalseOrderByCreatedAtDesc(
                        userEmail
                )
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void markAsRead(
            Integer notificationId,
            String userEmail) {

        Notification notification =
                notificationRepository
                        .findById(notificationId)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Notification not found"
                                )
                        );

        if (!notification
                .getUserEmail()
                .equals(userEmail)) {

            throw new IllegalArgumentException(
                    "You cannot modify another user's notification"
            );
        }

        notification.setReadStatus(true);

        notificationRepository.save(notification);
    }

    private NotificationResponse mapToResponse(
            Notification notification) {

        return new NotificationResponse(
                notification.getNotificationId(),
                notification.getNoteId(),
                notification.getMessage(),
                notification.getCreatedAt(),
                notification.isReadStatus()
        );
    }
}