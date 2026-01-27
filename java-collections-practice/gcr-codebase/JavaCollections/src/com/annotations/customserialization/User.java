package com.annotations.customserialization;

public class User {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password; // Not serialized

    public User(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
}
