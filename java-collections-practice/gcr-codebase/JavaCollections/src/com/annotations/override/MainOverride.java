package com.annotations.override;

import java.util.Scanner;

public class MainOverride {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Do you want to hear the Dog sound? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes")) {
                Animal myDog = new Dog();  // Upcasting
                myDog.makeSound();         // Calls overridden method
            } else {
                System.out.println("Okay, no sound for now.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
