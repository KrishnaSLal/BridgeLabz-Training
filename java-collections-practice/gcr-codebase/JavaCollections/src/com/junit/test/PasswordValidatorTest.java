package com.junit.test;

import org.junit.jupiter.api.Test;

import com.junit.com.PasswordValidator;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    // Valid passwords
    @Test
    void testValidPasswords() {
        assertTrue(validator.isValid("Password1"));
        assertTrue(validator.isValid("Secure9X"));
    }

    // Too short
    @Test
    void testTooShortPassword() {
        assertFalse(validator.isValid("Pass1"));
    }

    // No uppercase letter
    @Test
    void testNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    // No digit
    @Test
    void testNoDigit() {
        assertFalse(validator.isValid("Password"));
    }

    // Null password
    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}