package com.fundoo.auth.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TokenCacheService {

    private static final String TOKEN_PREFIX =
            "fundoo:auth:token:";

    private final StringRedisTemplate redisTemplate;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    public TokenCacheService(
            StringRedisTemplate redisTemplate) {

        this.redisTemplate = redisTemplate;
    }

    public void saveToken(
            String token,
            String email) {

        String key = TOKEN_PREFIX + token;

        redisTemplate.opsForValue().set(
                key,
                email,
                Duration.ofMillis(jwtExpiration)
        );
    }

    public boolean isTokenCached(String token) {

        String key = TOKEN_PREFIX + token;

        return Boolean.TRUE.equals(
                redisTemplate.hasKey(key)
        );
    }

    public void deleteToken(String token) {

        String key = TOKEN_PREFIX + token;

        redisTemplate.delete(key);
    }

    public String getEmail(String token) {

        String key = TOKEN_PREFIX + token;

        return redisTemplate.opsForValue()
                .get(key);
    }
}