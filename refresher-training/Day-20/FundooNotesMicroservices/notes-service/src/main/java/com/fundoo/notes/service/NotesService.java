package com.fundoo.notes.service;

import java.util.List;

import com.fundoo.notes.dto.NotesRequest;
import com.fundoo.notes.dto.NotesResponse;

public interface NotesService {

    NotesResponse createNote(
            NotesRequest request,
            int userId
    );

    List<NotesResponse> getAllNotes(
            int userId
    );

    NotesResponse getNoteById(
            int noteId,
            int userId
    );

    NotesResponse updateNote(
            int noteId,
            NotesRequest request,
            int userId
    );

    NotesResponse togglePin(
            int noteId,
            int userId
    );

    List<NotesResponse> getPinnedNotes(
            int userId
    );

    NotesResponse toggleArchive(
            int noteId,
            int userId
    );

    List<NotesResponse> getArchivedNotes(
            int userId
    );

    NotesResponse moveToTrash(
            int noteId,
            int userId
    );

    NotesResponse restoreNote(
            int noteId,
            int userId
    );

    List<NotesResponse> getTrashNotes(
            int userId
    );

    void permanentlyDelete(
            int noteId,
            int userId
    );

    List<NotesResponse> searchAndFilter(
            int userId,
            String keyword,
            Boolean pinned,
            Boolean archived,
            Boolean trashed,
            String label
    );

    List<NotesResponse> getNotesByLabel(
            int labelId,
            int userId
    );

    void requestExport(
            int userId,
            String format
    );
}