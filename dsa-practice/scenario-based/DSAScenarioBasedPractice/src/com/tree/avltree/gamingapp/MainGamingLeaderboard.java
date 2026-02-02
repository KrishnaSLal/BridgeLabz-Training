//Story: Gaming App - Real-Time Leaderboard
//Gamers earn and lose points rapidly.
//Scenarios:
//● 🔹 Scenario 1: Insert/Update Player — New players join or existing ones gain points.
//● 🔹 Scenario 2: Display Top Players — Return top 10 players in rank.
//● 🔹 Scenario 3: Remove Player — Handle user bans or exits efficiently.

package com.tree.avltree.gamingapp;

import java.util.Scanner;

public class MainGamingLeaderboard {

    public static void main(String[] args) {

        LeaderboardBST leaderboard = new LeaderboardBST();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Gaming Leaderboard =====");
            System.out.println("1. Add/Update Player");
            System.out.println("2. Remove Player");
            System.out.println("3. Show Top 10 Players");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter Player ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Player Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Points: ");
                    int points = sc.nextInt();
                    leaderboard.insertOrUpdate(id, name, points);
                    System.out.println("Player added/updated.");
                    break;

                case 2:
                    System.out.print("Enter Player ID to remove: ");
                    id = sc.nextInt();
                    leaderboard.remove(id);
                    System.out.println("Player removed");
                    break;

                case 3:
                    leaderboard.displayTop(10);
                    break;

                case 4:
                    System.out.println("Exiting leaderboard.");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
