package com.fundoo.gateway.fallback;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/auth")
    public ResponseEntity<Map<String, Object>> authFallback() {

        return createResponse(
                "Authentication service is temporarily unavailable"
        );
    }

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> userFallback() {

        return createResponse(
                "User service is temporarily unavailable"
        );
    }

    @GetMapping("/notes")
    public ResponseEntity<Map<String, Object>> notesFallback() {

        return createResponse(
                "Notes service is temporarily unavailable"
        );
    }

    @GetMapping("/reminders")
    public ResponseEntity<Map<String, Object>> reminderFallback() {

        return createResponse(
                "Reminder service is temporarily unavailable"
        );
    }

    @GetMapping("/export")
    public ResponseEntity<Map<String, Object>> exportFallback() {

        return createResponse(
                "Export service is temporarily unavailable"
        );
    }

    private ResponseEntity<Map<String, Object>> createResponse(
            String message) {

        Map<String, Object> response =
                new LinkedHashMap<>();

        response.put(
                "timestamp",
                LocalDateTime.now()
        );

        response.put(
                "status",
                503
        );

        response.put(
                "error",
                "SERVICE_UNAVAILABLE"
        );

        response.put(
                "message",
                message
        );

        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(response);
    }
}