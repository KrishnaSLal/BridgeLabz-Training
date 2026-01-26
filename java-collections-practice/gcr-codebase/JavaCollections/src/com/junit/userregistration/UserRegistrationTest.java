package com.junit.userregistration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    UserRegistration registration = new UserRegistration();

    // Valid registration
    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> {
            registration.registerUser("krishna", "krishna@example.com", "Password1");
        });
    }

    // Invalid username
    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("ab", "user@example.com", "Password1");
        });
    }

    // Invalid email
    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("username", "userexample.com", "Password1");
        });
    }

    // Invalid password
    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("username", "user@example.com", "password");
        });
    }

    // Null inputs
    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser(null, null, null);
        });
    }
}
