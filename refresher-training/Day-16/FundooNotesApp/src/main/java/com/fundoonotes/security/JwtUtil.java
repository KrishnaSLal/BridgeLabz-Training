package com.fundoonotes.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigningKey() {

        byte[] keyBytes =
                Decoders.BASE64.decode(secret);

        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(
            String userId,
            String email) {

        Date now = new Date();

        Date expiryDate =
                new Date(
                        now.getTime() + expiration
                );

        return Jwts.builder()
                .subject(userId)
                .claim("email", email)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    public String extractUserId(String token) {

        return getClaims(token)
                .getSubject();
    }

    public String extractEmail(String token) {

        return getClaims(token)
                .get("email", String.class);
    }

    public boolean isTokenValid(String token) {

        try {

            getClaims(token);

            return true;

        } catch (Exception exception) {

            return false;
        }
    }

    public long getExpiration() {

        return expiration;
    }

    private Claims getClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}