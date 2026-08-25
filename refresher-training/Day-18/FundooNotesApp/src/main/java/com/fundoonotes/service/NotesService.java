package com.fundoonotes.service;

import java.util.List;

import com.fundoonotes.dto.NotesRequest;
import com.fundoonotes.dto.NotesResponse;

public interface NotesService {

    // =========================================================
    // CRUD
    // =========================================================

    NotesResponse createNote(
            NotesRequest request,
            String email
    );

    List<NotesResponse> getAllNotes(
            String email
    );

    NotesResponse getNoteById(
            int noteId,
            String email
    );

    NotesResponse updateNote(
            int noteId,
            NotesRequest request,
            String email
    );

    void permanentlyDelete(
            int noteId,
            String email
    );

    // =========================================================
    // PIN
    // =========================================================

    NotesResponse togglePin(
            int noteId,
            String email
    );

    List<NotesResponse> getPinnedNotes(
            String email
    );

    // =========================================================
    // ARCHIVE
    // =========================================================

    NotesResponse toggleArchive(
            int noteId,
            String email
    );

    List<NotesResponse> getArchivedNotes(
            String email
    );

    // =========================================================
    // TRASH
    // =========================================================

    NotesResponse moveToTrash(
            int noteId,
            String email
    );

    NotesResponse restoreNote(
            int noteId,
            String email
    );

    List<NotesResponse> getTrashNotes(
            String email
    );

    // =========================================================
    // SEARCH + FILTER
    // =========================================================

    List<NotesResponse> searchAndFilter(
            String email,
            String keyword,
            Boolean pinned,
            Boolean archived,
            Boolean trashed,
            String label
    );

    // =========================================================
    // LABEL
    // =========================================================

    List<NotesResponse> getNotesByLabel(
            int labelId,
            String email
    );
    
 // =========================================================
 // EXPORT
 // =========================================================

    void requestExport(
         String email,
         String format
 );
}