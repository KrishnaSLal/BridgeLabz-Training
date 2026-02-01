//String Length Checker
//○ Scenario: Check if a message exceeds character limit.
//○ Task: Use Function<String, Integer>.

package com.interfaces.functionalinterface.stringlengthchecker;

import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        
        int maxLimit = 10;

        Function<String, Integer> stringLengthFunction = str -> str.length();

        String message1 = "Hello";
        String message2 = "Hello, Functional Interface!";

        // Check messages
        checkMessage(message1, maxLimit, stringLengthFunction);
        checkMessage(message2, maxLimit, stringLengthFunction);
    }

    public static void checkMessage(String message, int limit, Function<String, Integer> lengthFunction) {
        int length = lengthFunction.apply(message); 
        if (length > limit) {
            System.out.println("Message exceeds the limit Length: " + length);
        } else {
            System.out.println("Message is within the limit Length: " + length);
        }
    }
}

