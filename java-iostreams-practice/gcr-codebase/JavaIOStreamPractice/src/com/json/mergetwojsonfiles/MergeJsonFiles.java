package com.json.mergetwojsonfiles;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeJsonFiles {

    public static void main(String[] args) throws Exception {

        // Read JSON files
        String json1 = new String(Files.readAllBytes(Paths.get("C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\json\\mergetwojsonfiles\\file1.json")));
        String json2 = new String(Files.readAllBytes(Paths.get("C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\json\\mergetwojsonfiles\\file2.json")));

        JSONObject jsonObject1 = new JSONObject(json1);
        JSONObject jsonObject2 = new JSONObject(json2);

        // Merge jsonObject2 into jsonObject1
        for (String key : jsonObject2.keySet()) {
            jsonObject1.put(key, jsonObject2.get(key));
        }

        System.out.println("Merged JSON:");
        System.out.println(jsonObject1.toString(4));
    }
}
