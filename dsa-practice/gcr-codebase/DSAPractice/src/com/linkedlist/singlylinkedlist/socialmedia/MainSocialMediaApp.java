package com.linkedlist.singlylinkedlist.socialmedia;

import java.util.Scanner;

public class MainSocialMediaApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();
        int choice;

        do {
            System.out.println("\n--- Social Media Friend Connections ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display Friends of a User");
            System.out.println("6. Search User by Name");
            System.out.println("7. Search User by ID");
            System.out.println("8. Count Friends of All Users");
            System.out.println("9. Display All Users");
            System.out.println("10. Exit");

            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1 -> {
                    System.out.print("User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sm.addUser(id, name, age);
                }
                case 2 -> {
                    System.out.print("User ID 1: ");
                    int u1 = sc.nextInt();
                    System.out.print("User ID 2: ");
                    int u2 = sc.nextInt();
                    sm.addFriend(u1, u2);
                }
                case 3 -> {
                    System.out.print("User ID 1: ");
                    int u1 = sc.nextInt();
                    System.out.print("User ID 2: ");
                    int u2 = sc.nextInt();
                    sm.removeFriend(u1, u2);
                }
                case 4 -> {
                    System.out.print("User ID 1: ");
                    int u1 = sc.nextInt();
                    System.out.print("User ID 2: ");
                    int u2 = sc.nextInt();
                    sm.mutualFriends(u1, u2);
                }
                case 5 -> {
                    System.out.print("User ID: ");
                    int u = sc.nextInt();
                    SocialMedia.UserNode user = sm.findUserById(u);
                    if (user != null) sm.displayFriends(user);
                    else System.out.println("User not found.");
                }
                case 6 -> {
                    sc.nextLine(); // consume leftover newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    sm.searchByName(name);
                }
                case 7 -> {
                    System.out.print("Enter User ID: ");
                    int u = sc.nextInt();
                    SocialMedia.UserNode user = sm.findUserById(u);
                    if (user != null) sm.displayUser(user);
                    else System.out.println("User not found.");
                }
                case 8 -> sm.countFriends();
                case 9 -> sm.displayAllUsers();
                case 10 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 10);

        sc.close();
    }
}
