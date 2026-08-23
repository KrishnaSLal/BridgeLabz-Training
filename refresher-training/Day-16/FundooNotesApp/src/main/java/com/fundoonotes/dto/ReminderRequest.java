package com.fundoonotes.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ReminderRequest {

    @NotNull
    private Integer noteId;

    @NotNull
    @Future
    private LocalDateTime reminderTime;

    @NotBlank
    private String message;
}