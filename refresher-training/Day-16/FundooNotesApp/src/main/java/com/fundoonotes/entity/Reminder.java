package com.fundoonotes.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reminders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reminderId;

    @Column(nullable = false)
    private Integer noteId;

    @Column(nullable = false)
    private LocalDateTime reminderTime;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private boolean sent = false;

    @Column(nullable = false)
    private String userEmail;
}