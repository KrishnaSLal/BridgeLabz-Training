package com.fundoo.notes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LabelRequest {

    @NotBlank(message = "Label name cannot be empty")
    @Size(
        min = 1,
        max = 50,
        message =
            "Label name must be between 1 and 50 characters"
    )
    private String name;

    public LabelRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}