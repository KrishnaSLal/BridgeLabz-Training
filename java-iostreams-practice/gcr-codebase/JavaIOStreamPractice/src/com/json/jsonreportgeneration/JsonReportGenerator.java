package com.json.jsonreportgeneration;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JsonReportGenerator {

    public static void main(String[] args) {

        List<Employee> employees =
                FileEmployeeReader.readEmployees("C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\json\\jsonreportgeneration\\employees.txt");

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(new File("employee-report.json"), employees);

            System.out.println("JSON report generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
