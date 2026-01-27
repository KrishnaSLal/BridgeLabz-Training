package com.reflection.objectmapper;

import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapperUtil {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create object dynamically
            T obj = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                try {
                    Field field = clazz.getDeclaredField(entry.getKey());
                    field.setAccessible(true);
                    field.set(obj, entry.getValue());
                } catch (NoSuchFieldException e) {
                    System.out.println("Ignoring unknown field: " + entry.getKey());
                }
            }
            return obj;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
