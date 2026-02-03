package com.json.mergejsonobjects;

import org.json.JSONObject;

public class Merge {
    public static void main(String[] args) {

        JSONObject json1 = new JSONObject();
        json1.put("name", "Krishna");
        json1.put("email", "krishna@gmail.com");

        JSONObject json2 = new JSONObject();
        json2.put("phone", "9876543210");
        json2.put("city", "Bangalore");

        // Merge
        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        System.out.println(json1.toString(2));
    }
}
