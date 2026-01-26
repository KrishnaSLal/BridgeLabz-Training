package com.junit.userregistration;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {

        if (username == null || username.length() < 4) {
            throw new IllegalArgumentException("Invalid username");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (password == null ||
                password.length() < 8 ||
                !password.matches(".*[A-Z].*") ||
                !password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Invalid password");
        }

        // Simulate successful registration
        System.out.println("User registered successfully");
    }
}
