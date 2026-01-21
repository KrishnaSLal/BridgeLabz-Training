//5. FitnessTracker – Daily Step Count Ranking (Bubble Sort)
//Story: A fitness app tracks steps taken by each user in a small group (less than 20 people). At
//the end of the day, it displays rankings. Since the list is small and frequently shuffled due to
//last-minute step syncing, a simple Bubble Sort runs quickly to generate the leaderboard.
//Concepts Involved:
//● Bubble Sort
//● Frequent updates
//● Real-time re-sorting

package com.fitnesstracker;

import java.util.Scanner;

public class MainFitnessTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        sc.nextLine();

        UserSteps[] users = new UserSteps[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter user name: ");
            String name = sc.nextLine();

            System.out.print("Enter steps taken: ");
            int steps = sc.nextInt();
            sc.nextLine();
            
            System.out.println("---------------------");

            users[i] = new UserSteps(name, steps);
        }

       
        Rankings.bubbleSort(users);

        
        System.out.println("\nRankings :");
        for (int i = 0; i < users.length; i++) {
            System.out.println( (i + 1) + ". " + users[i].name + " - " + users[i].getStep() + " steps");
        }

        sc.close();
    }
}
