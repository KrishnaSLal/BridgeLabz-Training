package com.linkedlist.circularlinkedlist.roundrobin;

import java.util.Scanner;

public class MainRoundRobinApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler rr = new RoundRobinScheduler();
        int choice;

        do {
            System.out.println("\n--- Round Robin Scheduler Menu ---");
            System.out.println("1. Add Process");
            System.out.println("2. Display Queue");
            System.out.println("3. Simulate Round Robin");
            System.out.println("4. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Process ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Burst Time: ");
                    int bt = sc.nextInt();
                    System.out.print("Priority: ");
                    int pr = sc.nextInt();
                    rr.addProcess(pid, bt, pr);
                }
                case 2 -> rr.displayQueue();
                case 3 -> {
                    System.out.print("Enter Time Quantum: ");
                    int tq = sc.nextInt();
                    rr.simulate(tq);
                }
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
