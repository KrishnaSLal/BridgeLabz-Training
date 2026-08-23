package com.fundoonotes.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fundoonotes.dto.LoginRequest;
import com.fundoonotes.dto.RegisterRequest;
import com.fundoonotes.entity.User;
import com.fundoonotes.repository.UserRepository;
import com.fundoonotes.security.JwtUtil;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final TokenCacheService tokenCacheService;

    public UserService(
            UserRepository userRepository,
            JwtUtil jwtUtil,
            PasswordEncoder passwordEncoder,
            TokenCacheService tokenCacheService) {

        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.tokenCacheService = tokenCacheService;
    }

    // =========================
    // REGISTER
    // =========================

    public String register(RegisterRequest request) {

        if (userRepository
                .findByEmail(request.getEmail())
                .isPresent()) {

            throw new IllegalArgumentException(
                    "Email already registered"
            );
        }

        User user = new User();

        user.setEmail(request.getEmail());
        user.setName(request.getName());

        String encodedPassword =
                passwordEncoder.encode(
                        request.getPassword()
                );

        user.setPasswordHash(encodedPassword);

        userRepository.save(user);

        return "User registered successfully";
    }

    // =========================
    // LOGIN
    // =========================

    public String login(LoginRequest request) {

        User user =
                userRepository
                        .findByEmail(request.getEmail())
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Invalid email or password"
                                )
                        );

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPasswordHash()
                );

        if (!passwordMatches) {

            throw new IllegalArgumentException(
                    "Invalid email or password"
            );
        }

        String token =
                jwtUtil.generateToken(
                        String.valueOf(user.getUserId()),
                        user.getEmail()
                );

        // ===============================
        // SAVE TOKEN IN REDIS
        // ===============================

        tokenCacheService.saveToken(
                token,
                user.getEmail(),
                jwtUtil.getExpiration()
        );

        return token;
    }

    // =========================
    // LOGOUT
    // =========================

    public void logout(String token) {

        tokenCacheService.deleteToken(token);
    }
}