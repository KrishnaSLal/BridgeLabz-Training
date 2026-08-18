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

    public UserService(
            UserRepository userRepository,
            JwtUtil jwtUtil,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

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

        User savedUser =
                userRepository.save(user);

        return jwtUtil.generateToken(
                String.valueOf(savedUser.getUserId()),
                savedUser.getEmail()
        );
    }

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

        return jwtUtil.generateToken(
                String.valueOf(user.getUserId()),
                user.getEmail()
        );
    }
}