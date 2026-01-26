package com.javastreams.serialization;

import java.io.*;
import java.util.List;

public class EmployeeManager {

    private static final String FILE_NAME = "employees.dat";

    // Serialize employee list
    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(employees);
            System.out.println("Employees saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while saving employees.");
            e.printStackTrace();
        }
    }

    // Deserialize employee list
    @SuppressWarnings("unchecked")
    public static List<Employee> loadEmployees() {
        List<Employee> employees = null;

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            employees = (List<Employee>) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Employee file not found.");
        } catch (IOException e) {
            System.out.println("Error while reading employees.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found.");
            e.printStackTrace();
        }

        return employees;
    }
}
