package com.fundoo.reminder.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoo.reminder.entity.Reminder;

public interface ReminderRepository
        extends JpaRepository<Reminder, Integer> {

    List<Reminder> findByUserId(int userId);

    List<Reminder> findByUserIdAndSent(
            int userId,
            boolean sent
    );

    List<Reminder> findByReminderTimeLessThanEqualAndSent(
            LocalDateTime time,
            boolean sent
    );
}