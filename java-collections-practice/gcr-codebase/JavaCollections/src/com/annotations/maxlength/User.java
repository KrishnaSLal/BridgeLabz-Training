package com.annotations.maxlength;
import java.lang.reflect.Field;

public class User {

    @MaxLength(10)
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    private void validateMaxLength(String value) {
        try {
            Field field = this.getClass().getDeclaredField("username");

            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);

                if (value.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                        "Username exceeds max length of " + maxLength.value()
                    );
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}
