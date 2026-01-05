package com.linkedlist.circularlinkedlist.taskscheduler;

import java.util.Scanner;

public class MainTaskSchedulerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        int choice;

        do {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current & Next Task");
            System.out.println("6. Search Task by Priority");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date = sc.nextLine();

                    if (choice == 1)
                        scheduler.addTaskBeginning(id, name, priority, date);
                    else if (choice == 2)
                        scheduler.addTaskEnd(id, name, priority, date);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        scheduler.addTaskAtPosition(pos, id, name, priority, date);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Task ID to remove: ");
                    scheduler.removeTask(sc.nextInt());
                }
                case 5 -> scheduler.viewNextTask();
                case 6 -> {
                    System.out.print("Enter Priority to search: ");
                    scheduler.searchByPriority(sc.nextInt());
                }
                case 7 -> scheduler.displayAll();
                case 8 -> System.out.println("Exiting Task Scheduler...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 8);

        sc.close();
    }
}
