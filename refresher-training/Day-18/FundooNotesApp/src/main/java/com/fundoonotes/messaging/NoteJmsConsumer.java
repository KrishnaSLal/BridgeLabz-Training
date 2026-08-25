package com.fundoonotes.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.fundoonotes.config.JmsConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NoteJmsConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(
                    NoteJmsConsumer.class
            );

    private final ObjectMapper objectMapper;

    public NoteJmsConsumer(
            ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
    }

    @JmsListener(
            destination = JmsConfig.NOTE_EVENT_QUEUE
    )
    public void receiveMessage(
            String message) {

        try {

            NoteJmsEvent event =
                    objectMapper.readValue(
                            message,
                            NoteJmsEvent.class
                    );

            log.info(
                    "JMS message received: {}",
                    event
            );

            /*
             * This is where we can later add
             * actual asynchronous processing.
             *
             * For now, the consumer records the
             * note activity.
             */

            processEvent(event);

        } catch (Exception e) {

            log.error(
                    "Error processing JMS message: {}",
                    message,
                    e
            );

            /*
             * Re-throw so JMS knows processing failed.
             */
            throw new IllegalStateException(
                    "Failed to process JMS message",
                    e
            );
        }
    }

    private void processEvent(
            NoteJmsEvent event) {

        log.info(
                "Processing JMS event | Action: {} | Note ID: {} | User: {} | Message: {}",
                event.getAction(),
                event.getNoteId(),
                event.getEmail(),
                event.getMessage()
        );
    }
}