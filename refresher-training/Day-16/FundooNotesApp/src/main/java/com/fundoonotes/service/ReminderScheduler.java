package com.fundoonotes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fundoonotes.dto.ReminderMessage;
import com.fundoonotes.entity.Reminder;
import com.fundoonotes.repository.ReminderRepository;

@Component
public class ReminderScheduler {

    private final ReminderRepository reminderRepository;
    private final ReminderMessageProducer messageProducer;

    public ReminderScheduler(
            ReminderRepository reminderRepository,
            ReminderMessageProducer messageProducer) {

        this.reminderRepository =
                reminderRepository;

        this.messageProducer =
                messageProducer;
    }

    @Scheduled(fixedDelay = 10000)
    public void publishDueReminders() {

        LocalDateTime currentTime =
                LocalDateTime.now();

        List<Reminder> reminders =
                reminderRepository
                        .findByReminderTimeLessThanEqualAndSentFalse(
                                currentTime
                        );

        for (Reminder reminder : reminders) {

            ReminderMessage message =
                    new ReminderMessage(
                            reminder.getReminderId(),
                            reminder.getNoteId(),
                            reminder.getUserEmail(),
                            reminder.getMessage(),
                            reminder.getReminderTime()
                    );

            // Send message to JMS queue
            messageProducer.sendReminder(message);

            // Mark reminder as sent
            reminder.setSent(true);

            reminderRepository.save(reminder);
        }
    }
}