package com.reflection.dependencyinjection;

import java.lang.reflect.Field;

public class DIContainer {

    public static <T> T getBean(Class<T> clazz) {
        try {
            // Create object of main class
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Scan fields for @Inject
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    // Get type of dependency
                    Class<?> dependencyClass = field.getType();

                    // Recursively create dependency object
                    Object dependency = getBean(dependencyClass);

                    // Inject dependency
                    field.setAccessible(true);
                    field.set(obj, dependency);
                }
            }

            return obj;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create bean: " + clazz.getName(), e);
        }
    }
}
