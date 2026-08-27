package com.fundoo.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.fundoo.user.dto.UserUpdateRequest;
import com.fundoo.user.entity.User;
import com.fundoo.user.service.UserManagementService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserManagementService userService;

    public UserController(
            UserManagementService userService) {

        this.userService = userService;
    }

    // =====================================================
    // GET USER
    // =====================================================

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(
            @PathVariable int userId) {

        User user =
                userService.getUserById(userId);

        return ResponseEntity.ok(user);
    }

    // =====================================================
    // GET ALL USERS
    // =====================================================

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        return ResponseEntity.ok(
                userService.getAllUsers()
        );
    }

    // =====================================================
    // UPDATE USER
    // =====================================================

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable int userId,
            @Valid @RequestBody
            UserUpdateRequest request) {

        User updatedUser =
                userService.updateUser(
                    userId,
                    request
                );

        return ResponseEntity.ok(updatedUser);
    }

    // =====================================================
    // DELETE USER
    // =====================================================

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(
            @PathVariable int userId) {

        userService.deleteUser(userId);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}