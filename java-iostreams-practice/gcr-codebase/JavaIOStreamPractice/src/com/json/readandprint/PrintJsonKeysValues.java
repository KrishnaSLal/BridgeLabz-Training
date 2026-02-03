package com.json.readandprint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class PrintJsonKeysValues {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\json\\readandprint\\data.json"));

        printJson(root, "");
    }

    // Recursive method to handle nested objects
    public static void printJson(JsonNode node, String prefix) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJson(entry.getValue(), prefix + entry.getKey() + ".");
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), prefix + "[" + i + "].");
            }
        } else {
            System.out.println(prefix.substring(0, prefix.length() - 1) + " : " + node.asText());
        }
    }
}
