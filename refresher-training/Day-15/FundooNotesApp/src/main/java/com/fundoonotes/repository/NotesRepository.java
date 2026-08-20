package com.fundoonotes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fundoonotes.entity.Notes;
import com.fundoonotes.entity.User;

public interface NotesRepository
        extends JpaRepository<Notes, Integer> {

    Optional<Notes> findByNoteIdAndUser(
            int noteId,
            User user
    );

    List<Notes> findAllByUser(User user);

    List<Notes> findAllByUserAndArchived(
            User user,
            boolean archived
    );

    List<Notes> findAllByUserAndTrashed(
            User user,
            boolean trashed
    );

    @Query("""
        SELECT DISTINCT n
        FROM Notes n
        LEFT JOIN n.labels l
        WHERE n.user = :user
        AND (
            LOWER(n.title) LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR
            LOWER(n.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
        )
        AND (:pinned IS NULL OR n.pinned = :pinned)
        AND (:archived IS NULL OR n.archived = :archived)
        AND (:trashed IS NULL OR n.trashed = :trashed)
        AND (
            :label IS NULL
            OR LOWER(l.name) = LOWER(:label)
        )
    """)
    List<Notes> searchAndFilter(
            @Param("user") User user,
            @Param("keyword") String keyword,
            @Param("pinned") Boolean pinned,
            @Param("archived") Boolean archived,
            @Param("trashed") Boolean trashed,
            @Param("label") String label
    );
}