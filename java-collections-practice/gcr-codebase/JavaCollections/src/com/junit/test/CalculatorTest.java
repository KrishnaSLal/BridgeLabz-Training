package com.junit.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junit.com.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // Test addition
    @Test
    void testAdd() {
        assertEquals(10, calculator.add(5, 5));
        assertEquals(-2, calculator.add(-5, 3));
    }

    // Test subtraction
    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-8, calculator.subtract(-5, 3));
    }

    // Test multiplication
    @Test
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
        assertEquals(0, calculator.multiply(5, 0));
    }

    // Test division
    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(10, 5));
    }

    // Bonus: Division by zero
    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}
