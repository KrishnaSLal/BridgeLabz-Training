package com.fundoo.notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoo.notification.entity.Notification;

public interface NotificationRepository
        extends JpaRepository<Notification, Integer> {

    List<Notification>
    findByUserIdOrderByCreatedAtDesc(int userId);
}