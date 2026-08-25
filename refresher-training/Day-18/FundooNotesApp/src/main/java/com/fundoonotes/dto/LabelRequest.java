package com.fundoonotes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LabelRequest {

    @NotBlank(message = "Label name cannot be empty")
    @Size(
        min = 1,
        max = 50,
        message = "Label name must be between 1 and 50 characters"
    )
    private String name;
}