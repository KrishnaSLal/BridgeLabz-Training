package com.fundoo.reminder.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.reminder.entity.Reminder;
import com.fundoo.reminder.messaging.ReminderJmsEvent;
import com.fundoo.reminder.messaging.ReminderMessagePublisher;
import com.fundoo.reminder.repository.ReminderRepository;

@Component
public class ReminderScheduler {

    private final ReminderRepository
            reminderRepository;

    private final ReminderMessagePublisher
            reminderMessagePublisher;

    public ReminderScheduler(
            ReminderRepository reminderRepository,
            ReminderMessagePublisher reminderMessagePublisher) {

        this.reminderRepository =
                reminderRepository;

        this.reminderMessagePublisher =
                reminderMessagePublisher;
    }

    @Scheduled(fixedRate = 30000)
    @Transactional
    public void processReminders() {

        LocalDateTime now =
                LocalDateTime.now();

        List<Reminder> reminders =
                reminderRepository
                        .findByReminderTimeLessThanEqualAndSent(
                                now,
                                false
                        );

        for (Reminder reminder : reminders) {

            ReminderJmsEvent event =
                    new ReminderJmsEvent(
                            reminder.getReminderId(),
                            reminder.getNoteId(),
                            reminder.getUserId(),
                            reminder.getEmail(),
                            reminder.getMessage()
                    );

            reminderMessagePublisher
                    .sendReminder(event);

            reminder.setSent(true);

            reminderRepository.save(
                    reminder
            );
        }
    }
}