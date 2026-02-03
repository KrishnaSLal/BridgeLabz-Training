package com.json.validateemail;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.everit.json.schema.ValidationException;
import org.json.JSONObject;

public class JsonSchemaValidation {

    public static void main(String[] args) {

        String jsonData = "{ \"name\":\"Krishna\", \"email\":\"krishna@gmail.com\", \"age\":25 }";

        String jsonSchema = "{ \"type\":\"object\","
                + "\"properties\":{"
                + "\"email\":{ \"type\":\"string\", \"format\":\"email\" }"
                + "},"
                + "\"required\":[\"email\"] }";

        try {
            JSONObject schemaJson = new JSONObject(jsonSchema);
            Schema schema = SchemaLoader.load(schemaJson);

            JSONObject dataJson = new JSONObject(jsonData);
            schema.validate(dataJson);

            System.out.println("Email is valid");
        } catch (ValidationException e) {
            System.out.println("Invalid email format");
        }
    }
}
