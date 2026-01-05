package com.stacksandqueues.sorting;

import java.util.Scanner;
import java.util.Stack;

public class SortStackUsingRecursion {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        sortStack(stack);
        insertInSortedOrder(stack, top);
    }

    // Helper function to insert element in sorted order
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertInSortedOrder(stack, element);
        stack.push(top);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter number of elements in stack: ");
        int n = scanner.nextInt();

        System.out.println("Enter stack elements:");
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack (Ascending Order): " + stack);

        scanner.close();
    }
}
