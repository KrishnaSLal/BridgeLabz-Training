package com.json.jsonfile;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonFile {
    public static void main(String[] args) throws Exception {

        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\json\\jsonfile\\users.json")));

        JSONObject jsonObject = new JSONObject(content);

        String name = jsonObject.getString("name");
        String email = jsonObject.getString("email");

        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }
}

