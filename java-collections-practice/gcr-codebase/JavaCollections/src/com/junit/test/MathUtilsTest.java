package com.junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.junit.com.MathUtils;

public class MathUtilsTest {

    MathUtils mathUtils = new MathUtils();

    @Test
    public void testDivideSuccess() {
        int result = mathUtils.divide(10, 2);
        assertEquals(5, result);
    }
}