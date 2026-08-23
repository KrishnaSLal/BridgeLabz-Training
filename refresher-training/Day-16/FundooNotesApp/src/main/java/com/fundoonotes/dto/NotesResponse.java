package com.fundoonotes.dto;

import java.util.List;

import lombok.Data;

@Data
public class NotesResponse {

    private int noteId;

    private String title;

    private String description;

    private boolean pinned;

    private boolean archived;

    private boolean trashed;

    private List<String> labels;
}