package com.fundoonotes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.dto.NotificationResponse;
import com.fundoonotes.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(
            NotificationService notificationService) {

        this.notificationService =
                notificationService;
    }

    // =========================
    // GET ALL NOTIFICATIONS
    // =========================

    @GetMapping
    public ResponseEntity<List<NotificationResponse>>
            getNotifications(
                    Authentication authentication) {

        String email =
                authentication.getName();

        return ResponseEntity.ok(
                notificationService
                        .getMyNotifications(email)
        );
    }

    // =========================
    // GET UNREAD
    // =========================

    @GetMapping("/unread")
    public ResponseEntity<List<NotificationResponse>>
            getUnreadNotifications(
                    Authentication authentication) {

        String email =
                authentication.getName();

        return ResponseEntity.ok(
                notificationService
                        .getUnreadNotifications(email)
        );
    }

    // =========================
    // MARK AS READ
    // =========================

    @PatchMapping("/{notificationId}/read")
    public ResponseEntity<String> markAsRead(
            @PathVariable Integer notificationId,
            Authentication authentication) {

        String email =
                authentication.getName();

        notificationService.markAsRead(
                notificationId,
                email
        );

        return ResponseEntity.ok(
                "Notification marked as read"
        );
    }
}