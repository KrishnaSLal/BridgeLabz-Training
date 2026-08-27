package com.fundoo.notes.service;

import java.util.List;

import com.fundoo.notes.dto.LabelRequest;
import com.fundoo.notes.entity.Label;

public interface LabelService {

    Label createLabel(
            LabelRequest request,
            int userId
    );

    List<Label> getAllLabels(
            int userId
    );

    Label updateLabel(
            int labelId,
            LabelRequest request,
            int userId
    );

    void deleteLabel(
            int labelId,
            int userId
    );
}