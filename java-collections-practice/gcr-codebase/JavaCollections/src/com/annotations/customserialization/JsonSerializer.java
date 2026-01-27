package com.annotations.customserialization;

import java.lang.reflect.Field;

public class JsonSerializer {

    public static String toJson(Object object) {

        StringBuilder json = new StringBuilder();
        json.append("{");

        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);

                try {
                    Object value = field.get(object);

                    json.append("\"")
                        .append(annotation.name())
                        .append("\": ");

                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }

                    json.append(", ");

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Remove trailing comma
        if (json.charAt(json.length() - 2) == ',') {
            json.delete(json.length() - 2, json.length());
        }

        json.append("}");
        return json.toString();
    }
}
