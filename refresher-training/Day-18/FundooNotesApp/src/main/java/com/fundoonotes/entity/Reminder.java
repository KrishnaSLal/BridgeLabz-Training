package com.fundoonotes.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "reminders")
@Data
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reminderId;

    @Column(nullable = false)
    private int noteId;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDateTime reminderTime;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private boolean triggered = false;
}