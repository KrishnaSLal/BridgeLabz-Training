package com.stacksandqueues.stockspan;

import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {

    public static void calculateSpan(int[] price, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[n];

        // First day span is always 1
        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < n; i++) {

            // Pop elements smaller or equal to current price
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            // Calculate span
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index
            stack.push(i);
        }

        // Display result
        System.out.println("Stock Spans:");
        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = scanner.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        calculateSpan(prices, n);

        scanner.close();
    }
}
