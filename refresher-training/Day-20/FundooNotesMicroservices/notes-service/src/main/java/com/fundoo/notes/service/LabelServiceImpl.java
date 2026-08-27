package com.fundoo.notes.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.notes.dto.LabelRequest;
import com.fundoo.notes.entity.Label;
import com.fundoo.notes.repository.LabelRepository;

@Service
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;

    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    @Transactional
    public Label createLabel(
            LabelRequest request,
            int userId) {

        String name = request.getName().trim();

        if (name.isEmpty()) {
            throw new IllegalArgumentException(
                    "Label name cannot be empty"
            );
        }

        if (labelRepository
                .findByNameAndUserId(name, userId)
                .isPresent()) {

            throw new IllegalArgumentException(
                    "Label already exists"
            );
        }

        Label label = new Label();

        label.setName(name);
        label.setUserId(userId);

        return labelRepository.save(label);
    }

    @Override
    public List<Label> getAllLabels(int userId) {

        return labelRepository
                .findAllByUserId(userId);
    }

    @Override
    @Transactional
    public Label updateLabel(
            int labelId,
            LabelRequest request,
            int userId) {

        Label label = labelRepository
                .findByLabelIdAndUserId(
                        labelId,
                        userId
                )
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Label not found"
                        )
                );

        String newName = request.getName().trim();

        if (newName.isEmpty()) {
            throw new IllegalArgumentException(
                    "Label name cannot be empty"
            );
        }

        labelRepository
                .findByNameAndUserId(
                        newName,
                        userId
                )
                .ifPresent(existing -> {

                    if (existing.getLabelId() != labelId) {

                        throw new IllegalArgumentException(
                                "Label already exists"
                        );
                    }
                });

        label.setName(newName);

        return labelRepository.save(label);
    }

    @Override
    @Transactional
    public void deleteLabel(
            int labelId,
            int userId) {

        Label label = labelRepository
                .findByLabelIdAndUserId(
                        labelId,
                        userId
                )
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Label not found"
                        )
                );

        labelRepository.delete(label);
    }
}