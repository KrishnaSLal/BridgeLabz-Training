package com.fundoonotes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public ResponseEntity<List<NotificationResponse>>
    getMyNotifications(
            Authentication authentication) {

        String email =
                authentication.getName();

        return ResponseEntity.ok(
                notificationService
                        .getMyNotifications(email)
        );
    }
}