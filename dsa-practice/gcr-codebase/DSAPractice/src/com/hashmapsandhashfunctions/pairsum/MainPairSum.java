package com.hashmapsandhashfunctions.pairsum;

import java.util.Scanner;

public class MainPairSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = scanner.nextInt();

        boolean result = PairSumService.hasPairWithSum(arr, target);

        if (!result) {
            System.out.println("No pair found with the given sum.");
        }

        scanner.close();
    }
}
