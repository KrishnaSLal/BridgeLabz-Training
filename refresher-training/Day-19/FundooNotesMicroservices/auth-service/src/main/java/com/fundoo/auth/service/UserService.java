package com.fundoo.auth.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fundoo.auth.dto.LoginRequest;
import com.fundoo.auth.dto.RegisterRequest;
import com.fundoo.auth.entity.User;
import com.fundoo.auth.repository.UserRepository;
import com.fundoo.auth.security.JwtUtil;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    private final EmailService emailService;

    private final TokenCacheService tokenCacheService;

    public UserService(
            UserRepository userRepository,
            JwtUtil jwtUtil,
            PasswordEncoder passwordEncoder,
            EmailService emailService,
            TokenCacheService tokenCacheService) {

        this.userRepository = userRepository;

        this.jwtUtil = jwtUtil;

        this.passwordEncoder = passwordEncoder;

        this.emailService = emailService;

        this.tokenCacheService = tokenCacheService;
    }

    // =====================================================
    // REGISTER
    // =====================================================

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

        user.setPasswordHash(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        userRepository.save(user);

        return "User registered successfully";
    }

    // =====================================================
    // LOGIN
    // =====================================================

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

        tokenCacheService.saveToken(
                token,
                user.getEmail()
        );

        return token;
    }

    // =====================================================
    // FORGOT PASSWORD
    // =====================================================

    public void forgotPassword(String email) {

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "User not found"
                                )
                        );

        String otp =
                String.format(
                        "%06d",
                        new Random().nextInt(1_000_000)
                );

        user.setResetOtp(otp);

        user.setResetOtpExpiry(
                LocalDateTime.now()
                        .plusMinutes(5)
        );

        user.setResetOtpVerified(false);

        userRepository.save(user);

        emailService.sendOtpEmail(
                user.getEmail(),
                otp
        );
    }

    // =====================================================
    // VERIFY OTP
    // =====================================================

    public void verifyOtp(
            String email,
            String otp) {

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "User not found"
                                )
                        );

        if (user.getResetOtp() == null
                || !user.getResetOtp().equals(otp)) {

            throw new IllegalArgumentException(
                    "Invalid OTP"
            );
        }

        if (user.getResetOtpExpiry() == null
                || LocalDateTime.now()
                    .isAfter(user.getResetOtpExpiry())) {

            throw new IllegalArgumentException(
                    "OTP has expired"
            );
        }

        user.setResetOtpVerified(true);

        userRepository.save(user);
    }

    // =====================================================
    // RESET PASSWORD
    // =====================================================

    public void resetPassword(
            String email,
            String newPassword) {

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "User not found"
                                )
                        );

        if (!user.isResetOtpVerified()) {

            throw new IllegalArgumentException(
                    "OTP verification required"
            );
        }

        user.setPasswordHash(
                passwordEncoder.encode(
                        newPassword
                )
        );

        user.setResetOtp(null);

        user.setResetOtpExpiry(null);

        user.setResetOtpVerified(false);

        userRepository.save(user);
    }

    // =====================================================
    // LOGOUT
    // =====================================================

    public void logout(String token) {

        tokenCacheService.deleteToken(token);
    }
}