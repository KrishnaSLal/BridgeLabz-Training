package com.fundoonotes.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fundoonotes.entity.Reminder;
import com.fundoonotes.messaging.ReminderJmsEvent;
import com.fundoonotes.messaging.ReminderJmsPublisher;
import com.fundoonotes.repository.ReminderRepository;

@Component
public class ReminderScheduler {

    private static final Logger log =
            LoggerFactory.getLogger(
                    ReminderScheduler.class
            );

    private final ReminderRepository reminderRepository;

    private final ReminderJmsPublisher reminderJmsPublisher;

    public ReminderScheduler(
            ReminderRepository reminderRepository,
            ReminderJmsPublisher reminderJmsPublisher) {

        this.reminderRepository =
                reminderRepository;

        this.reminderJmsPublisher =
                reminderJmsPublisher;
    }

    @Scheduled(
            fixedDelayString =
                    "${reminder.scheduler.delay-ms:30000}"
    )
    public void processReminders() {

        LocalDateTime now =
                LocalDateTime.now();

        List<Reminder> reminders =
                reminderRepository
                        .findByTriggeredFalseAndReminderTimeLessThanEqual(
                                now
                        );

        for (Reminder reminder : reminders) {

            try {

                ReminderJmsEvent event =
                        new ReminderJmsEvent(
                                reminder.getReminderId(),
                                reminder.getNoteId(),
                                reminder.getUserId(),
                                reminder.getEmail(),
                                reminder.getMessage()
                        );

                /*
                 * Send reminder to ActiveMQ.
                 */
                reminderJmsPublisher.publish(event);

                /*
                 * Mark as triggered ONLY after
                 * successful JMS publishing.
                 */
                reminder.setTriggered(true);

                reminderRepository.save(reminder);

                log.info(
                        "Reminder triggered: {}",
                        reminder.getReminderId()
                );

            } catch (Exception exception) {

                log.error(
                        "Failed to process reminder: {}",
                        reminder.getReminderId(),
                        exception
                );
            }
        }
    }
}