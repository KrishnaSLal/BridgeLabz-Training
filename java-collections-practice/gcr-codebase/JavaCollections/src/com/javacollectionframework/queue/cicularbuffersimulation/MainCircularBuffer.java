package com.javacollectionframework.queue.cicularbuffersimulation;

import java.util.Scanner;

public class MainCircularBuffer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter buffer size: ");
        int size = sc.nextInt();

        CircularBufferSimulation cb = new CircularBufferSimulation(size);

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Display Buffer");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = sc.nextInt();
                    cb.enqueue(value);
                    break;

                case 2:
                    cb.display();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
