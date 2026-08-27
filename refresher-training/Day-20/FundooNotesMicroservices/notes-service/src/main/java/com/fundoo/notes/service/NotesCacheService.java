package com.fundoo.notes.service;

import java.time.Duration;
import java.util.List;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fundoo.notes.dto.NotesResponse;

@Service
public class NotesCacheService {

    private static final String PREFIX =
            "fundoo:notes:";

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

    public String allKey(int userId) {
        return PREFIX + "user:" + userId + ":all";
    }

    public String noteKey(
            int userId,
            int noteId) {

        return PREFIX
                + "user:"
                + userId
                + ":note:"
                + noteId;
    }

    public String pinnedKey(int userId) {
        return PREFIX
                + "user:"
                + userId
                + ":pinned";
    }

    public String archivedKey(int userId) {
        return PREFIX
                + "user:"
                + userId
                + ":archived";
    }

    public String trashKey(int userId) {
        return PREFIX
                + "user:"
                + userId
                + ":trash";
    }

    public String labelKey(
            int userId,
            int labelId) {

        return PREFIX
                + "user:"
                + userId
                + ":label:"
                + labelId;
    }

    public String searchKey(
            int userId,
            String keyword,
            Boolean pinned,
            Boolean archived,
            Boolean trashed,
            String label) {

        return PREFIX
                + "user:"
                + userId
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
                    objectMapper.writeValueAsString(
                            notes
                    );

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
                    objectMapper.writeValueAsString(
                            note
                    );

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

    public void clearUserCache(int userId) {

        String pattern =
                PREFIX
                + "user:"
                + userId
                + ":*";

        var keys =
                redisTemplate.keys(pattern);

        if (keys != null &&
                !keys.isEmpty()) {

            redisTemplate.delete(keys);
        }
    }

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