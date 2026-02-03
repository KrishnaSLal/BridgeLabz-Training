package com.json.jsonobject;

import org.json.JSONObject;
import org.json.JSONArray;

public class StudentJsonObject {
    public static void main(String[] args) {

        JSONObject student = new JSONObject();
        student.put("id", 1);
        student.put("name", "Krishna");

        JSONArray subjects = new JSONArray();
        subjects.put("Java");
        subjects.put("Python");

        student.put("subjects", subjects);

        System.out.println(student.toString(2));
    }
}
