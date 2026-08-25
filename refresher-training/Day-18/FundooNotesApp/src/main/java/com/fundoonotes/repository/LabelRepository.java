package com.fundoonotes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoonotes.entity.Label;
import com.fundoonotes.entity.User;

public interface LabelRepository
        extends JpaRepository<Label, Integer> {

    // Find label belonging to specific user
    Optional<Label> findByLabelIdAndUser(
            int labelId,
            User user
    );

    // Find label by name for specific user
    Optional<Label> findByNameAndUser(
            String name,
            User user
    );

    // Get all labels of a user
    List<Label> findAllByUser(User user);
}