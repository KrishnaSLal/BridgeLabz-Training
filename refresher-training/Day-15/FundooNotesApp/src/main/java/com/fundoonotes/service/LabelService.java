package com.fundoonotes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoonotes.entity.Label;
import com.fundoonotes.entity.User;
import com.fundoonotes.repository.LabelRepository;
import com.fundoonotes.repository.UserRepository;

@Service
public class LabelService {

    private final LabelRepository labelRepository;
    private final UserRepository userRepository;

    public LabelService(
            LabelRepository labelRepository,
            UserRepository userRepository) {

        this.labelRepository = labelRepository;
        this.userRepository = userRepository;
    }

    public Label createLabel(
            String name,
            String email) {

        User user = getUser(email);

        String labelName = name.trim();

        if (labelName.isEmpty()) {
            throw new IllegalArgumentException(
                    "Label name cannot be empty"
            );
        }

        if (labelRepository
                .findByNameAndUser(labelName, user)
                .isPresent()) {

            throw new IllegalArgumentException(
                    "Label already exists"
            );
        }

        Label label = new Label();

        label.setName(labelName);
        label.setUser(user);

        return labelRepository.save(label);
    }

    public List<Label> getLabels(
            String email) {

        User user = getUser(email);

        return labelRepository.findAllByUser(user);
    }

    public void deleteLabel(
            int labelId,
            String email) {

        User user = getUser(email);

        Label label = labelRepository
                .findById(labelId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Label not found"
                        ));

        if (label.getUser().getUserId()
                != user.getUserId()) {

            throw new IllegalArgumentException(
                    "You are not authorized to delete this label"
            );
        }

        labelRepository.delete(label);
    }

    private User getUser(String email) {

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found"
                        ));
    }
}