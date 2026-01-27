package com.junit.com;

public class StringUtils {

    public String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        return str.equals(reverse(str));
    }

    public String toUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }
}
