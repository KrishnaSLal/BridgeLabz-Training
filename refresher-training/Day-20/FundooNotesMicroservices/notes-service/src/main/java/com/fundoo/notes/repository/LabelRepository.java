package com.fundoo.notes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoo.notes.entity.Label;

public interface LabelRepository
        extends JpaRepository<Label, Integer> {

    Optional<Label> findByLabelIdAndUserId(
            int labelId,
            int userId
    );

    Optional<Label> findByNameAndUserId(
            String name,
            int userId
    );

    List<Label> findAllByUserId(int userId);
}