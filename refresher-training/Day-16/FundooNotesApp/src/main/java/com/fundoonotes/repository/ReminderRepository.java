package com.fundoonotes.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoonotes.entity.Reminder;

public interface ReminderRepository
        extends JpaRepository<Reminder, Integer> {

    List<Reminder> findByUserEmailOrderByReminderTimeAsc(
            String userEmail
    );

    List<Reminder> findByReminderTimeLessThanEqualAndSentFalse(
            LocalDateTime currentTime
    );
}