//8. GamerZone – High Score Ranking System (Quick Sort)
//Story: A global multiplayer game needs to rank thousands of players in real-time based on their
//scores after every match. The list is dynamic, large, and often unsorted. Quick Sort is used to
//reorder players quickly for leaderboards.
//Concepts Involved:
//● Quick Sort
//● Sorting dynamic, large datasets
//● Performance-driven solution

package com.gamerzone;

import java.util.Scanner;

public class MainGamerZone {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of users: ");
        int numberOfUsers = sc.nextInt();

        Scores[] users = new Scores[numberOfUsers];

        for (int i = 0; i < numberOfUsers; i++) {

            System.out.print("Enter the user id " + (i + 1) + ": ");
            int id = sc.nextInt();

            System.out.print("Enter the score: ");
            int score = sc.nextInt();

            users[i] = new Scores(id, score);
        }

        RankingSystem ranking = new RankingSystem();

        ranking.quickSort(users, 0, users.length - 1);

        System.out.println("\nRanks: ");
        ranking.display(users);

        sc.close();
    }
}
