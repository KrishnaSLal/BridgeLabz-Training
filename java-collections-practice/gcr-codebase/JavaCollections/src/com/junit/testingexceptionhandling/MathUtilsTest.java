package com.junit.testingexceptionhandling;

import org.junit.Test;
import static org.junit.Assert.*;

public class MathUtilsTest {

    MathUtils mathUtils = new MathUtils();

    @Test
    public void testDivideSuccess() {
        int result = mathUtils.divide(10, 2);
        assertEquals(5, result);
    }
