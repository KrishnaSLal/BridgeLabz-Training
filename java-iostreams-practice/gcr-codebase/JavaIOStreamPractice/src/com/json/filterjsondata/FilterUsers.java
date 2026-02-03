package com.json.filterjsondata;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterUsers {
    public static void main(String[] args) throws Exception {
        String jsonArray = "[\n" +
                "  { \"name\": \"Krishna\", \"age\": 25, \"email\": \"krishna@gmail.com\" },\n" +
                "  { \"name\": \"Minakshi\", \"age\": 38, \"email\": \"anil@gmail.com\" },\n" +
                "  { \"name\": \"Arushi\", \"age\": 45, \"email\": \"rita@gmail.com\" }\n" +
                "]";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonArray);

        System.out.println("Users older than 25:");

        for (JsonNode user : root) {
            if (user.get("age").asInt() > 25) {
                System.out.println(user.get("name").asText() + " - " + user.get("age").asInt());
            }
        }
    }
}