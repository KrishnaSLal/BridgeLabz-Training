package com.fundoonotes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoonotes.entity.Notes;
import com.fundoonotes.entity.User;

public interface NotesRepository extends JpaRepository<Notes, Integer> {

    Optional<Notes> findByNoteIdAndUser(
            int noteId,
            User user
    );

    List<Notes> findAllByUser(User user);
}