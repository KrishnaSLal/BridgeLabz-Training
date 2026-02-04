package com.json.jsonreportgeneration;

import com.json.jsonreportgeneration.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeeReader {

    public static List<Employee> readEmployees(String filePath) {

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                employees.add(new Employee(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
}
