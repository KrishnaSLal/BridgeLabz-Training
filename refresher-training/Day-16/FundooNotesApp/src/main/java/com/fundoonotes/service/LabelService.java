package com.fundoonotes.service;

import java.util.List;

import com.fundoonotes.dto.LabelRequest;
import com.fundoonotes.entity.Label;

public interface LabelService {

    // CREATE
    Label createLabel(
            LabelRequest request,
            String email
    );

    // READ ALL
    List<Label> getAllLabels(
            String email
    );

    // UPDATE
    Label updateLabel(
            int labelId,
            LabelRequest request,
            String email
    );

    // DELETE
    void deleteLabel(
            int labelId,
            String email
    );
}