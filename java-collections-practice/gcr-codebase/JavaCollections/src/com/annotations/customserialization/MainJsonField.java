package com.annotations.customserialization;

import java.util.Scanner;

public class MainJsonField{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            User user = new User(username, age, password);

            String jsonOutput = JsonSerializer.toJson(user);

            System.out.println("\nGenerated JSON:");
            System.out.println(jsonOutput);

        } finally {
            scanner.close();
        }
    }
}
