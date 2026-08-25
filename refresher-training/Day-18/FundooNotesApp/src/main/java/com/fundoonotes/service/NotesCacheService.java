package com.fundoonotes.service;

import java.time.Duration;
import java.util.List;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fundoonotes.dto.NotesResponse;

@Service
public class NotesCacheService {

    private static final String PREFIX =
            "fundoo:notes:";

    //TTL - Time to live
    private static final Duration TTL =
            Duration.ofMinutes(10);

    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;

    public NotesCacheService(
            StringRedisTemplate redisTemplate,
            ObjectMapper objectMapper) {

        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    // =========================================================
    // KEY GENERATORS
    // =========================================================

    public String allKey(String email) {

        return PREFIX
                + "user:"
                + email
                + ":all";
    }

    public String noteKey(
            String email,
            int noteId) {

        return PREFIX
                + "user:"
                + email
                + ":note:"
                + noteId;
    }

    public String pinnedKey(String email) {

        return PREFIX
                + "user:"
                + email
                + ":pinned";
    }

    public String archivedKey(String email) {

        return PREFIX
                + "user:"
                + email
                + ":archived";
    }

    public String trashKey(String email) {

        return PREFIX
                + "user:"
                + email
                + ":trash";
    }

    public String labelKey(
            String email,
            int labelId) {

        return PREFIX
                + "user:"
                + email
                + ":label:"
                + labelId;
    }

    public String searchKey(
            String email,
            String keyword,
            Boolean pinned,
            Boolean archived,
            Boolean trashed,
            String label) {

        return PREFIX
                + "user:"
                + email
                + ":search:"
                + String.valueOf(keyword)
                + ":"
                + String.valueOf(pinned)
                + ":"
                + String.valueOf(archived)
                + ":"
                + String.valueOf(trashed)
                + ":"
                + String.valueOf(label);
    }

    // =========================================================
    // LIST CACHE
    // =========================================================

    public List<NotesResponse> getList(
            String key) {

        String json =
                redisTemplate
                        .opsForValue()
                        .get(key);

        if (json == null) {

            return null;
        }

        try {

            return objectMapper.readValue(
                    json,
                    objectMapper
                            .getTypeFactory()
                            .constructCollectionType(
                                    List.class,
                                    NotesResponse.class
                            )
            );

        } catch (JsonProcessingException e) {

            redisTemplate.delete(key);

            return null;
        }
    }

    public void putList(
            String key,
            List<NotesResponse> notes) {

        try {

            String json =
                    objectMapper.writeValueAsString(notes);

            redisTemplate
                    .opsForValue()
                    .set(
                            key,
                            json,
                            TTL
                    );

        } catch (JsonProcessingException e) {

            throw new IllegalStateException(
                    "Unable to cache notes",
                    e
            );
        }
    }

    // =========================================================
    // SINGLE NOTE CACHE
    // =========================================================

    public NotesResponse getNote(
            String key) {

        String json =
                redisTemplate
                        .opsForValue()
                        .get(key);

        if (json == null) {

            return null;
        }

        try {

            return objectMapper.readValue(
                    json,
                    NotesResponse.class
            );

        } catch (JsonProcessingException e) {

            redisTemplate.delete(key);

            return null;
        }
    }

    public void putNote(
            String key,
            NotesResponse note) {

        try {

            String json =
                    objectMapper.writeValueAsString(note);

            redisTemplate
                    .opsForValue()
                    .set(
                            key,
                            json,
                            TTL
                    );

        } catch (JsonProcessingException e) {

            throw new IllegalStateException(
                    "Unable to cache note",
                    e
            );
        }
    }

    // =========================================================
    // INVALIDATE USER CACHE
    // =========================================================

    public void clearUserCache(
            String email) {

        String pattern =
                PREFIX
                        + "user:"
                        + email
                        + ":*";

        var keys =
                redisTemplate
                        .keys(pattern);

        if (keys != null &&
                !keys.isEmpty()) {

            redisTemplate.delete(keys);
        }
    }

    // =========================================================
    // CLEAR ALL FUNDoo CACHE
    // =========================================================

    public void clearAll() {

        var keys =
                redisTemplate.keys(
                        PREFIX + "*"
               );

        if (keys != null &&
                !keys.isEmpty()) {

            redisTemplate.delete(keys);
        }
    }
}