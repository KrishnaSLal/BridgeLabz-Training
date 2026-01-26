package com.javacollectionframework.map.votingsystem;

import java.util.Scanner;

public class MainVoteManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VoteManager manager = new VoteManager();

        while (true) {
            System.out.println("\nVoting System Menu");
            System.out.println("1. Cast Vote");
            System.out.println("2. Display Votes in Order");
            System.out.println("3. Display Votes Sorted by Candidate Name");
            System.out.println("4. Display All Votes");
            System.out.println("5. Get Votes for a Candidate");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter candidate name: ");
                    String candidate = sc.nextLine();
                    manager.castVote(candidate);
                }
                case 2 -> manager.displayVotesInOrder();
                case 3 -> manager.displayVotesSorted();
                case 4 -> manager.displayAllVotes();
                case 5 -> {
                    System.out.print("Enter candidate name: ");
                    String candidate = sc.nextLine();
                    System.out.println(candidate + " has " + manager.getVotesForCandidate(candidate) + " votes.");
                }
                case 6 -> {
                    System.out.println("Exiting Voting System");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
