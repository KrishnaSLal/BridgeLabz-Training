package com.fundoonotes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.dto.AuthResponse;
import com.fundoonotes.dto.LoginRequest;
import com.fundoonotes.dto.RegisterRequest;
import com.fundoonotes.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {

        this.userService = userService;
    }

    // =========================
    // REGISTER
    // =========================

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        String message =
                userService.register(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new AuthResponse(message));
    }

    // =========================
    // LOGIN
    // =========================

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        String token =
                userService.login(request);

        return ResponseEntity
                .ok(new AuthResponse(token));
    }

    // =========================
    // LOGOUT
    // =========================

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            @RequestHeader("Authorization") String authorizationHeader) {

        if (authorizationHeader == null ||
                !authorizationHeader.startsWith("Bearer ")) {

            return ResponseEntity
                    .badRequest()
                    .body("Bearer token is required");
        }

        String token =
                authorizationHeader.substring(7);

        userService.logout(token);

        return ResponseEntity
                .ok("Logout successful");
    }
}