package com.fundoonotes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoonotes.entity.Label;
import com.fundoonotes.entity.User;

public interface LabelRepository extends JpaRepository<Label, Integer> {

    Optional<Label> findByNameAndUser(
            String name,
            User user
    );

    List<Label> findAllByUser(User user);
}