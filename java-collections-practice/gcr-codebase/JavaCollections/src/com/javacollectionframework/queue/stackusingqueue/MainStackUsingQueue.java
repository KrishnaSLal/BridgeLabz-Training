package com.javacollectionframework.queue.stackusingqueue;

import java.util.Scanner;

public class MainStackUsingQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StackUsingQueues stack = new StackUsingQueues();

        while (true) {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    System.out.println(value + " pushed");
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Popped: " + stack.pop());
                    }
                    break;

                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Top element: " + stack.top());
                    }
                    break;

                case 4:
                    System.out.println("Exiting");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
