package com.fundoo.notes.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fundoo.notes.config.JmsConfig;

@Service
public class NoteJmsPublisher {

    private static final Logger log =
            LoggerFactory.getLogger(
                    NoteJmsPublisher.class
            );

    private final JmsTemplate jmsTemplate;

    private final ObjectMapper objectMapper;

    public NoteJmsPublisher(
            JmsTemplate jmsTemplate,
            ObjectMapper objectMapper) {

        this.jmsTemplate = jmsTemplate;

        this.objectMapper = objectMapper;
    }

    public void publish(
            String action,
            Integer noteId,
            String userId,
            String message) {

        NoteJmsEvent event =
                new NoteJmsEvent(
                        action,
                        noteId,
                        userId,
                        message
                );

        try {

            String json =
                    objectMapper.writeValueAsString(
                            event
                    );

            jmsTemplate.convertAndSend(
                    JmsConfig.NOTE_EVENT_QUEUE,
                    json
            );

            log.info(
                    "JMS event published: {}",
                    json
            );

        } catch (JsonProcessingException e) {

            throw new IllegalStateException(
                    "Unable to publish JMS event",
                    e
            );
        }
    }
}