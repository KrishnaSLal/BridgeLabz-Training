package com.fundoonotes.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoonotes.dto.LabelRequest;
import com.fundoonotes.entity.Label;
import com.fundoonotes.entity.User;
import com.fundoonotes.repository.LabelRepository;
import com.fundoonotes.repository.UserRepository;

@Service
public class LabelServiceImpl
        implements LabelService {

    private final LabelRepository labelRepository;

    private final UserRepository userRepository;

    public LabelServiceImpl(
            LabelRepository labelRepository,
            UserRepository userRepository) {

        this.labelRepository = labelRepository;

        this.userRepository = userRepository;
    }

    // =========================================================
    // GET USER
    // =========================================================

    private User getUser(String email) {

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        ));
    }

    // =========================================================
    // CREATE LABEL
    // =========================================================

    @Override
    @Transactional
    public Label createLabel(
            LabelRequest request,
            String email) {

        User user = getUser(email);

        String name =
                request.getName().trim();

        if (name.isEmpty()) {
            throw new RuntimeException(
                    "Label name cannot be empty"
            );
        }

        /*
         * A user cannot have two labels
         * with the same name.
         */
        if (labelRepository
                .findByNameAndUser(
                        name,
                        user
                )
                .isPresent()) {

            throw new RuntimeException(
                    "Label already exists"
            );
        }

        Label label = new Label();

        label.setName(name);

        label.setUser(user);

        return labelRepository.save(label);
    }

    // =========================================================
    // GET ALL LABELS
    // =========================================================

    @Override
    public List<Label> getAllLabels(
            String email) {

        User user = getUser(email);

        return labelRepository
                .findAllByUser(user);
    }

    // =========================================================
    // UPDATE LABEL
    // =========================================================

    @Override
    @Transactional
    public Label updateLabel(
            int labelId,
            LabelRequest request,
            String email) {

        User user = getUser(email);

        Label label =
                labelRepository
                        .findByLabelIdAndUser(
                                labelId,
                                user
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Label not found"
                                ));

        String newName =
                request.getName().trim();

        if (newName.isEmpty()) {
            throw new RuntimeException(
                    "Label name cannot be empty"
            );
        }

        /*
         * Check duplicate label name.
         */
        labelRepository
                .findByNameAndUser(
                        newName,
                        user
                )
                .ifPresent(existing -> {

                    if (existing.getLabelId()
                            != labelId) {

                        throw new RuntimeException(
                                "Label already exists"
                        );
                    }
                });

        label.setName(newName);

        return labelRepository.save(label);
    }

    // =========================================================
    // DELETE LABEL
    // =========================================================

    @Override
    @Transactional
    public void deleteLabel(
            int labelId,
            String email) {

        User user = getUser(email);

        Label label =
                labelRepository
                        .findByLabelIdAndUser(
                                labelId,
                                user
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Label not found"
                                ));

        /*
         * Remove label from all associated notes
         * before deleting the label.
         */
        if (label.getNotes() != null) {

            label.getNotes()
                    .forEach(note ->
                            note.getLabels()
                                    .remove(label)
                    );

            label.getNotes().clear();
        }

        labelRepository.delete(label);
    }
}