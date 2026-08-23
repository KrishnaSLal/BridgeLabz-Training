package com.fundoonotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoonotes.entity.Notification;

public interface NotificationRepository
        extends JpaRepository<Notification, Integer> {

    List<Notification>
        findByUserEmailOrderByCreatedAtDesc(
                String userEmail
        );

    List<Notification>
        findByUserEmailAndReadStatusFalseOrderByCreatedAtDesc(
                String userEmail
        );
}