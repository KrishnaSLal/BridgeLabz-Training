//Convert JSON to CSV and Vice Versa
//Read a JSON file containing a list of students.
//Convert it into CSV format and save it.


package com.csvdatahandling.advancedproblems.convertjsontocsv;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonCsvConverter {

    public static void main(String[] args) throws Exception {

        jsonToCsv("students.json", "students.csv");
        csvToJson("students.csv", "students_converted.json");

        System.out.println("JSON - CSV conversion completed");
    }

    // 1️JSON → CSV
    public static void jsonToCsv(String jsonFile, String csvFile) throws Exception {

        String jsonContent = Files.readString(Paths.get(jsonFile));
        JSONArray students = new JSONArray(jsonContent);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            // CSV Header
            bw.write("id,name,age,marks");
            bw.newLine();

            for (int i = 0; i < students.length(); i++) {
                JSONObject s = students.getJSONObject(i);

                bw.write(
                    s.getInt("id") + "," +
                    s.getString("name") + "," +
                    s.getInt("age") + "," +
                    s.getInt("marks")
                );
                bw.newLine();
            }
        }
    }

    // 2️ CSV → JSON
    public static void csvToJson(String csvFile, String jsonFile) throws Exception {

        JSONArray students = new JSONArray();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String header = br.readLine(); // skip header
            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                JSONObject obj = new JSONObject();
                obj.put("id", Integer.parseInt(data[0]));
                obj.put("name", data[1]);
                obj.put("age", Integer.parseInt(data[2]));
                obj.put("marks", Integer.parseInt(data[3]));

                students.put(obj);
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile))) {
            bw.write(students.toString(2)); 
        }
    }
}
