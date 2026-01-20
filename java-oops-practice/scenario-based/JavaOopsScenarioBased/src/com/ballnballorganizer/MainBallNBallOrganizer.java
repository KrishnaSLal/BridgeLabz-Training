package com.ballnballorganizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBallNBallOrganizer {

    private static List<Bag> bags = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("TinyTown Bag-n-Ball Organizer: ");
            System.out.println("1. Add Bag");
            System.out.println("2. Add Ball to Bag");
            System.out.println("3. Remove Ball from Bag");
            System.out.println("4. Display Balls in a Bag");
            System.out.println("5. Display All Bags");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> addBag();
                case 2 -> addBallToBag();
                case 3 -> removeBallFromBag();
                case 4 -> displayBallsInBag();
                case 5 -> displayAllBags();
                case 0 -> System.out.println("Exited!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    private static void addBag() {
        System.out.print("Enter Bag ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Bag Color: ");
        String color = sc.nextLine();
        System.out.print("Enter Bag Capacity: ");
        int capacity = sc.nextInt();

        bags.add(new Bag(id, color, capacity));
        System.out.println("Bag added successfully.");
    }

    private static void addBallToBag() {
        Bag bag = findBag();
        if (bag == null) return;

        System.out.print("Enter Ball ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Ball Color: ");
        String color = sc.nextLine();
        System.out.print("Enter Ball Size (Small/Medium/Large): ");
        String size = sc.nextLine();

        bag.addBall(new Balls(id, color, size));
    }

    private static void removeBallFromBag() {
        Bag bag = findBag();
        if (bag == null) return;

        System.out.print("Enter Ball ID to remove: ");
        String ballId = sc.nextLine();
        bag.removeBall(ballId);
    }

    private static void displayBallsInBag() {
        Bag bag = findBag();
        if (bag != null) {
            bag.displayBalls();
        }
    }

    private static void displayAllBags() {
        if (bags.isEmpty()) {
            System.out.println("No bags available.");
            return;
        }
        for (Bag bag : bags) {
            System.out.println("Bag ID: " + bag.getId() +", Color: " + bag.getColor() +", Ball Count: " + bag.getBallCount());
        }
    }

    private static Bag findBag() {
        System.out.print("Enter Bag ID: ");
        String bagId = sc.nextLine();

        for (Bag bag : bags) {
            if (bag.getId().equals(bagId)) {
                return bag;
            }
        }
        System.out.println(" Bag not found.");
        return null;
    }
}
