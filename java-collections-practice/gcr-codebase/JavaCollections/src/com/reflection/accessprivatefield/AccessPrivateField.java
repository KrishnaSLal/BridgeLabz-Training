package com.reflection.accessprivatefield;

import java.lang.reflect.Field;

public class AccessPrivateField {

    public static void main(String[] args) {
        try {
            // Create object of Person
            Person person = new Person();

            // Get Class object
            Class<?> clazz = person.getClass();

            // Get private field 'age'
            Field ageField = clazz.getDeclaredField("age");

            // Make private field accessible
            ageField.setAccessible(true);

            // Get original value
            int originalAge = ageField.getInt(person);
            System.out.println("Original Age: " + originalAge);

            // Modify value
            ageField.setInt(person, 35);

            // Get modified value
            int modifiedAge = ageField.getInt(person);
            System.out.println("Modified Age: " + modifiedAge);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
