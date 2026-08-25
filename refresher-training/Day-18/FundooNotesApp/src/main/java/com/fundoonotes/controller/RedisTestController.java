package com.fundoonotes.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    private final StringRedisTemplate redisTemplate;

    public RedisTestController(
            StringRedisTemplate redisTemplate) {

        this.redisTemplate =
                redisTemplate;
    }

    @GetMapping("/test/redis")
    public ResponseEntity<String> testRedis() {

        String key =
                "fundoo:test";

        String value =
                "Redis is working";

        /*
         * SET
         */
        redisTemplate
                .opsForValue()
                .set(
                        key,
                        value
                );

        /*
         * GET
         */
        String result =
                redisTemplate
                        .opsForValue()
                        .get(key);

        return ResponseEntity.ok(
                result
        );
    }
}