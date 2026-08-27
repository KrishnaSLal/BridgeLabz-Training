package com.fundoo.export.service;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

@Service
public class ExportService {

    public byte[] exportNotes(
            int userId,
            String format) {

        if (format == null || format.isBlank()) {

            throw new IllegalArgumentException(
                    "Export format is required"
            );
        }

        String normalizedFormat =
                format.trim().toLowerCase();

        /*
         * For now the export-service receives
         * the user ID through the event.
         *
         * Actual note retrieval will be done
         * through notes-service.
         */

        String content =
                "Export requested for user: "
                + userId
                + "\nFormat: "
                + normalizedFormat;

        return content.getBytes(
                StandardCharsets.UTF_8
        );
    }
}