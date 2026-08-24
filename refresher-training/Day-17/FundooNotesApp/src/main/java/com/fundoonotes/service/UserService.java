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
    private final EmailService emailService;
    
    public UserService(
            UserRepository userRepository,
            JwtUtil jwtUtil,
            PasswordEncoder passwordEncoder,
            EmailService emailService) {

        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    // =========================
    // REGISTER
    // =========================

    public String register(RegisterRequest request) {

        // Check whether email already exists
        if (userRepository
                .findByEmail(request.getEmail())
                .isPresent()) {

            throw new IllegalArgumentException(
                    "Email already registered"
            );
        }

        // Create new user
        User user = new User();

        user.setEmail(request.getEmail());
        user.setName(request.getName());

        // Encrypt password before saving
        String encodedPassword =
                passwordEncoder.encode(
                        request.getPassword()
                );

        user.setPasswordHash(encodedPassword);

        // Save user
        userRepository.save(user);

        // Do NOT generate JWT during registration
        return "User registered successfully";
    }


    // =========================
    // LOGIN
    // =========================

    public String login(LoginRequest request) {

        // Find user by email
        User user =
                userRepository
                    .findByEmail(request.getEmail())
                    .orElseThrow(() ->
                        new IllegalArgumentException(
                            "Invalid email or password"
                        )
                    );

        // Compare entered password
        // with encrypted password in database
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

        // Generate JWT ONLY after successful login
        return jwtUtil.generateToken(
                String.valueOf(user.getUserId()),
                user.getEmail()
        );
    }
    
    //FORGOT PASSWORD
    
    public void forgotPassword(String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found"
                        )
                );

        String otp = String.format(
                "%06d",
                new java.util.Random().nextInt(1000000)
        );

        user.setResetOtp(otp);
        user.setResetOtpExpiry(
                java.time.LocalDateTime.now().plusMinutes(5)
        );
        user.setResetOtpVerified(false);

        userRepository.save(user);

        emailService.sendOtpEmail(
                user.getEmail(),
                otp
        );
    }
    
    //VERIFY OTP
    
    public void verifyOtp(
            String email,
            String otp) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found"
                        )
                );

        if (user.getResetOtp() == null ||
            !user.getResetOtp().equals(otp)) {

            throw new IllegalArgumentException(
                    "Invalid OTP"
            );
        }

        if (user.getResetOtpExpiry() == null ||
            java.time.LocalDateTime.now()
                .isAfter(user.getResetOtpExpiry())) {

            throw new IllegalArgumentException(
                    "OTP has expired"
            );
        }

        user.setResetOtpVerified(true);

        userRepository.save(user);
    }
    
    //RESET PASSWORD
    
    public void resetPassword(
            String email,
            String newPassword) {

        User user = userRepository
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
                passwordEncoder.encode(newPassword)
        );

        user.setResetOtp(null);
        user.setResetOtpExpiry(null);
        user.setResetOtpVerified(false);

        userRepository.save(user);
    }
    
}