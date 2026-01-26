package com.junit.stringutilitymethods;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    StringUtils utils = new StringUtils();

    @Test
    public void testReverse() {
        assertEquals("olleh", utils.reverse("hello"));
        assertEquals("", utils.reverse(""));
        assertNull(utils.reverse(null));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(utils.isPalindrome("madam"));
        assertTrue(utils.isPalindrome("level"));
        assertFalse(utils.isPalindrome("hello"));
        assertFalse(utils.isPalindrome(null));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
        assertEquals("JAVA", utils.toUpperCase("java"));
        assertEquals("", utils.toUpperCase(""));
        assertNull(utils.toUpperCase(null));
    }
}
