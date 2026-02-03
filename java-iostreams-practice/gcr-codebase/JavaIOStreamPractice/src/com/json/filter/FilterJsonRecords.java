package com.json.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterJsonRecords {
    public static void main(String[] args) throws Exception {

        String jsonArray = "[\n" +
                "  { \"name\": \"Krishna\", \"email\": \"krishna@gmail.com\", \"age\": 25 },\n" +
                "  { \"name\": \"Rudresh\", \"email\": \"anil@gmail.com\", \"age\": 28 },\n" +
                "  { \"name\": \"Arushi\", \"email\": \"rita@gmail.com\", \"age\": 30 }\n" +
                "]";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonArray);

        System.out.println("Users with age > 25:");

        for (JsonNode node : root) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node.get("name").asText() + " - " + node.get("age").asInt());
            }
        }
    }
}
