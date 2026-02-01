//Name Uppercasing
//○ Scenario: Convert all employee names in uppercase for an HR letter.
//○ Task: Use String::toUpperCase in a stream.

package com.methodreferences.nameuppercasing;

import java.util.*;

public class MainNameUppercasing {

    public static void main(String[] args) {

        List<String> employeeNames =
                Arrays.asList("krishna", "arjun", "sneha", "rahul");

        // Method reference assigned to functional interface
        Name transformer = String::toUpperCase;

        List<String> upperCaseNames = employeeNames.stream().map(transformer::transform).toList();          

        upperCaseNames.forEach(System.out::println);
    }
}
