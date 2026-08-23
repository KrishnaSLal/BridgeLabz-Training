package com.fundoonotes.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fundoonotes.service.TokenCacheService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter
        extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final TokenCacheService tokenCacheService;

    public JwtAuthenticationFilter(
            JwtUtil jwtUtil,
            TokenCacheService tokenCacheService) {

        this.jwtUtil = jwtUtil;
        this.tokenCacheService = tokenCacheService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader =
                request.getHeader("Authorization");

        if (authorizationHeader != null &&
                authorizationHeader.startsWith("Bearer ")) {

            String token =
                    authorizationHeader.substring(7);

            String email =
                    tokenCacheService.getEmail(token);

            // ===============================
            // REDIS CACHE HIT
            // ===============================

            if (email != null) {

                setAuthentication(email);

            }

            // ===============================
            // REDIS CACHE MISS
            // ===============================

            else if (jwtUtil.isTokenValid(token)) {

                email =
                        jwtUtil.extractEmail(token);

                // Store token in Redis
                tokenCacheService.saveToken(
                        token,
                        email,
                        jwtUtil.getExpiration()
                );

                setAuthentication(email);
            }
        }

        filterChain.doFilter(request, response);
    }

    private void setAuthentication(String email) {

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        email,
                        null,
                        Collections.emptyList()
                );

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);
    }
}