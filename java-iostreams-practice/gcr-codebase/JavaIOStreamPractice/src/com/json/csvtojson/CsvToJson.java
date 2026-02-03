package com.json.csvtojson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;

public class CsvToJson {

    public static void main(String[] args) throws Exception {

        String csvFile = "C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\json\\csvtojson\\students.csv";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));

        String headerLine = br.readLine();
        String[] headers = headerLine.split(",");

        JSONArray jsonArray = new JSONArray();
        String line;

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");

            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i < headers.length; i++) {
                jsonObject.put(headers[i], values[i]);
            }
            jsonArray.put(jsonObject);
        }

        br.close();

        System.out.println(jsonArray.toString(4));
    }
}
