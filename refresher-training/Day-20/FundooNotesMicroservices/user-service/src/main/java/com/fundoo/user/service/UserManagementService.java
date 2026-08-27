package com.fundoo.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoo.user.dto.UserUpdateRequest;
import com.fundoo.user.entity.User;
import com.fundoo.user.exception.ResourceNotFoundException;
import com.fundoo.user.repository.UserRepository;

@Service
public class UserManagementService {

    private final UserRepository userRepository;

    public UserManagementService(
            UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    // =====================================================
    // GET USER BY ID
    // =====================================================

    public User getUserById(int userId) {

        return userRepository
                .findById(userId)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "User not found with ID: "
                        + userId
                    )
                );
    }

    // =====================================================
    // GET USER BY EMAIL
    // =====================================================

    public User getUserByEmail(String email) {

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "User not found with email: "
                        + email
                    )
                );
    }

    // =====================================================
    // GET ALL USERS
    // =====================================================

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    // =====================================================
    // UPDATE USER
    // =====================================================

    public User updateUser(
            int userId,
            UserUpdateRequest request) {

        User user =
                getUserById(userId);

        if (!user.getEmail()
                .equalsIgnoreCase(request.getEmail())) {

            userRepository
                    .findByEmail(request.getEmail())
                    .ifPresent(existingUser -> {

                        if (existingUser.getUserId()
                                != userId) {

                            throw new IllegalArgumentException(
                                "Email already registered"
                            );
                        }
                    });
        }

        user.setName(request.getName());

        user.setEmail(request.getEmail());

        return userRepository.save(user);
    }

    // =====================================================
    // DELETE USER
    // =====================================================

    public void deleteUser(int userId) {

        User user =
                getUserById(userId);

        userRepository.delete(user);
    }
}