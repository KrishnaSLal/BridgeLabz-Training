package com.fundoonotes.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    private final StringRedisTemplate redisTemplate;

    public RedisTestController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/test/redis")
    public String testRedis() {

        redisTemplate.opsForValue()
                .set("fundoo:test", "Redis is working");

        String value = redisTemplate.opsForValue()
                .get("fundoo:test");

        return value;
    }
}