package com.fundoonotes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.messaging.NoteJmsPublisher;

@RestController
public class JmsTestController {

    private final NoteJmsPublisher noteJmsPublisher;

    public JmsTestController(
            NoteJmsPublisher noteJmsPublisher) {

        this.noteJmsPublisher =
                noteJmsPublisher;
    }

    @GetMapping("/test/jms")
    public ResponseEntity<String> testJms() {

        noteJmsPublisher.publish(
                "JMS_TEST",
                0,
                "test@fundoo.com",
                "JMS is working successfully"
        );

        return ResponseEntity.ok(
                "JMS message published successfully"
        );
    }
}