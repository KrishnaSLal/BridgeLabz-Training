package com.annotations.maxlength;

import java.util.Scanner;

public class MainMaxLength {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            User user = new User(username);

            System.out.println("User created successfully!");
            System.out.println("Username: " + user.getUsername());

        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
