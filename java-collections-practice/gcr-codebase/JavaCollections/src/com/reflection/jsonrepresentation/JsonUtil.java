package com.reflection.jsonrepresentation;

import java.lang.reflect.Field;

public class JsonUtil {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        Class<?> clazz = obj.getClass();

        json.append("{");

        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);

            try {
                json.append("\"").append(fields[i].getName()) .append("\": ");

                Object value = fields[i].get(obj);

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                if (i < fields.length - 1) {
                    json.append(", ");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }
}
