//Validated using JSon Node

package com.json.validatejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonStructureValidation {

    public static void main(String[] args) {
        String json = "{ \"name\": \"Krishna\", \"email\": \"krishna@gmail.com\", \"age\": 25 }";

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode root = mapper.readTree(json);

            boolean valid =
                    root.has("name") &&
                    root.has("email") &&
                    root.get("name").isTextual() &&
                    root.get("email").isTextual();

            if (valid) {
                System.out.println("JSON structure is valid");
            } else {
                System.out.println("JSON structure is invalid");
            }

        } catch (Exception e) {
            System.out.println("Invalid JSON format");
        }
    }
}

