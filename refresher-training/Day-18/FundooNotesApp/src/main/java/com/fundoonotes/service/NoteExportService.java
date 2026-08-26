package com.fundoonotes.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.fundoonotes.entity.Notes;
import com.fundoonotes.entity.User;
import com.fundoonotes.repository.NotesRepository;
import com.fundoonotes.repository.UserRepository;

@Service
public class NoteExportService {

    private final NotesRepository notesRepository;
    private final UserRepository userRepository;

    public NoteExportService(
            NotesRepository notesRepository,
            UserRepository userRepository) {

        this.notesRepository = notesRepository;
        this.userRepository = userRepository;
    }

    public void exportNotes(
            int userId,
            String format) {

        if (!"CSV".equalsIgnoreCase(format)) {
            throw new IllegalArgumentException(
                    "Only CSV export is currently supported"
            );
        }

        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found"
                        )
                );

        List<Notes> notes =
                notesRepository.findAllByUser(user);

        File directory =
                new File("exports");

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName =
                "exports/notes-user-" + userId + ".csv";

        try (FileWriter writer =
                     new FileWriter(fileName)) {

            writer.write(
                    "Note ID,Title,Description,Pinned,Archived,Trashed\n"
            );

            for (Notes note : notes) {

                writer.write(
                        note.getNoteId()
                        + ","
                        + escape(note.getTitle())
                        + ","
                        + escape(note.getDescription())
                        + ","
                        + note.isPinned()
                        + ","
                        + note.isArchived()
                        + ","
                        + note.isTrashed()
                        + "\n"
                );
            }

            System.out.println(
                    "Notes exported successfully: "
                    + fileName
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to export notes",
                    e
            );
        }
    }

    private String escape(String value) {

        if (value == null) {
            return "";
        }

        return "\""
                + value.replace("\"", "\"\"")
                + "\"";
    }

    public Resource getExportedFile(int userId) throws IOException {

        String fileName =
                "exports/notes-user-" + userId + ".csv";

        File file = new File(fileName);

        if (!file.exists() || !file.isFile()) {
            return null;
        }

        return new UrlResource(file.toURI());
    }
}