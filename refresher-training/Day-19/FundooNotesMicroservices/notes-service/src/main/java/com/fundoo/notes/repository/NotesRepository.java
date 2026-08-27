package com.fundoo.notes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fundoo.notes.entity.Notes;

public interface NotesRepository
        extends JpaRepository<Notes, Integer> {

    List<Notes> findAllByUserId(int userId);

    Optional<Notes> findByNoteIdAndUserId(
            int noteId,
            int userId
    );

    List<Notes> findAllByUserIdAndPinned(
            int userId,
            boolean pinned
    );

    List<Notes> findAllByUserIdAndArchived(
            int userId,
            boolean archived
    );

    List<Notes> findAllByUserIdAndTrashed(
            int userId,
            boolean trashed
    );

    @Query("""
        SELECT DISTINCT n
        FROM Notes n
        LEFT JOIN n.labels l
        WHERE n.userId = :userId

        AND (
            :keyword IS NULL
            OR :keyword = ''
            OR LOWER(n.title)
                LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR LOWER(n.description)
                LIKE LOWER(CONCAT('%', :keyword, '%'))
        )

        AND (
            :pinned IS NULL
            OR n.pinned = :pinned
        )

        AND (
            :archived IS NULL
            OR n.archived = :archived
        )

        AND (
            :trashed IS NULL
            OR n.trashed = :trashed
        )

        AND (
            :label IS NULL
            OR :label = ''
            OR LOWER(l.name) = LOWER(:label)
        )
    """)
    List<Notes> searchAndFilter(
            @Param("userId") int userId,
            @Param("keyword") String keyword,
            @Param("pinned") Boolean pinned,
            @Param("archived") Boolean archived,
            @Param("trashed") Boolean trashed,
            @Param("label") String label
    );

    @Query("""
        SELECT DISTINCT n
        FROM Notes n
        JOIN n.labels l
        WHERE n.userId = :userId
        AND l.labelId = :labelId
    """)
    List<Notes> findAllByLabel(
            @Param("userId") int userId,
            @Param("labelId") int labelId
    );
}