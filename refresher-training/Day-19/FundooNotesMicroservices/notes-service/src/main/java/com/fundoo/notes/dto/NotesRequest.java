package com.fundoo.notes.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;

public class NotesRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private Set<Integer> labels;

    public NotesRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Integer> getLabels() {
        return labels;
    }

    public void setLabels(Set<Integer> labels) {
        this.labels = labels;
    }
}