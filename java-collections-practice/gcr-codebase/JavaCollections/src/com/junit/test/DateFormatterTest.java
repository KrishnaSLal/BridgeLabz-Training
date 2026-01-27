package com.junit.test;

import org.junit.jupiter.api.Test;

import com.junit.com.DateFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    // Valid date
    @Test
    void testValidDate() {
        assertEquals("25-12-2023", formatter.formatDate("2023-12-25"));
        assertEquals("01-01-2024", formatter.formatDate("2024-01-01"));
    }

    // Invalid date format
    @Test
    void testInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("25-12-2023");
        });
    }

    // Invalid date value
    @Test
    void testInvalidDateValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("2023-02-30");
        });
    }

    // Null input
    @Test
    void testNullDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate(null);
        });
    }
}