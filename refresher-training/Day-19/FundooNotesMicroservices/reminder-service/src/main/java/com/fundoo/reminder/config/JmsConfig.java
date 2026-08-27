package com.fundoo.reminder.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {

    public static final String REMINDER_QUEUE =
            "fundoo.reminder.events";
}