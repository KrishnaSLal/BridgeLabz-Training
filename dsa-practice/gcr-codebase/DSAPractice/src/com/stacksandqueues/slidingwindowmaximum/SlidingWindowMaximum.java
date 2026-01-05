package com.stacksandqueues.slidingwindowmaximum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SlidingWindowMaximum {

    public static void printMax(int[] arr, int n, int k) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // Remove elements out of this window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements (not useful)
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Print max for current window
            if (i >= k - 1) {
                System.out.print(arr[deque.peekFirst()] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter window size k: ");
        int k = scanner.nextInt();

        System.out.println("Sliding Window Maximums:");
        printMax(arr, n, k);

        scanner.close();
    }
}
