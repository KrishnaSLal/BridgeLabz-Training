package com.junit.testingparametrizedtests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {

    NumberUtils utils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testEvenNumbers(int number) {
        assertTrue(utils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testOddNumbers(int number) {
        assertFalse(utils.isEven(number));
    }
}
