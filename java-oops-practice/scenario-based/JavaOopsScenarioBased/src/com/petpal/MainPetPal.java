package com.petpal;

import java.util.Scanner;

public class MainPetPal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to PetPal");

        // Choose pet type
        System.out.println("Choose a pet: 1. Dog  2. Cat  3. Bird");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        Pet pet;

        // Create pet
        switch (choice) {
            case 1:
                System.out.print("Enter Dog's name (or press Enter for default): ");
                String dogName = sc.nextLine();
                pet = dogName.isEmpty() ? new Dog() : new Dog(dogName, 2);
                break;
            case 2:
                System.out.print("Enter Cat's name (or press Enter for default): ");
                String catName = sc.nextLine();
                pet = catName.isEmpty() ? new Cat() : new Cat(catName, 2);
                break;
            case 3:
                System.out.print("Enter Bird's name (or press Enter for default): ");
                String birdName = sc.nextLine();
                pet = birdName.isEmpty() ? new Bird() : new Bird(birdName, 1);
                break;
            default:
                System.out.println("Invalid choice! Default Dog created.");
                pet = new Dog();
        }

        pet.displayStatus();
        pet.makeSound();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an action: 1. Feed  2. Play  3. Sleep  4. Status  5. Exit");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1:
                    pet.feed();
                    break;
                case 2:
                    pet.play();
                    break;
                case 3:
                    pet.sleep();
                    break;
                case 4:
                    pet.displayStatus();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Goodbye! Take care of " + pet.name);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
