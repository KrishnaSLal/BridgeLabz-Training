package com.hashmapsandhashfunctions.longestconsecutivesequence;

import java.util.Scanner;

public class MainLongestConsecutive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = LongestConsecutiveService.findLongestConsecutiveSequence(arr);

        System.out.println("Length of Longest Consecutive Sequence: " + result);

        scanner.close();
    }
}













