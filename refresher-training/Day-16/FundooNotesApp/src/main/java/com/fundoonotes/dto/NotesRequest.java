package com.fundoonotes.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NotesRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private Set<Integer> labels;
}