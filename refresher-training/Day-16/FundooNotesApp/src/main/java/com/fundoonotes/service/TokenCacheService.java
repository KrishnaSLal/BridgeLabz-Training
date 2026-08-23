package com.fundoonotes.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TokenCacheService {

    private static final String TOKEN_PREFIX = "fundoo:jwt:";

    private final StringRedisTemplate redisTemplate;

    public TokenCacheService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Store token -> email in Redis
    public void saveToken(String token, String email, long expirationMillis) {

        String key = generateRedisKey(token);

        Duration expiration =
                Duration.ofMillis(expirationMillis);

        redisTemplate.opsForValue()
                .set(key, email, expiration);
    }

    // Get email from Redis using token
    public String getEmail(String token) {

        String key = generateRedisKey(token);

        return redisTemplate.opsForValue()
                .get(key);
    }

    // Check whether token exists in Redis
    public boolean containsToken(String token) {

        String key = generateRedisKey(token);

        return Boolean.TRUE.equals(
                redisTemplate.hasKey(key)
        );
    }

    // Remove token from Redis
    public void deleteToken(String token) {

        String key = generateRedisKey(token);

        redisTemplate.delete(key);
    }

    // Generate SHA-256 based Redis key
    private String generateRedisKey(String token) {

        return TOKEN_PREFIX + sha256(token);
    }

    private String sha256(String value) {

        try {

            MessageDigest digest =
                    MessageDigest.getInstance("SHA-256");

            byte[] hash =
                    digest.digest(
                            value.getBytes(StandardCharsets.UTF_8)
                    );

            StringBuilder hexString =
                    new StringBuilder();

            for (byte b : hash) {

                String hex =
                        Integer.toHexString(
                                0xff & b
                        );

                if (hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException exception) {

            throw new IllegalStateException(
                    "SHA-256 algorithm not available",
                    exception
            );
        }
    }
}