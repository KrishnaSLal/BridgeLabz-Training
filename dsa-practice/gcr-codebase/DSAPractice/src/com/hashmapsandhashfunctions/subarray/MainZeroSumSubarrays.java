package com.hashmapsandhashfunctions.subarray;

import java.util.Scanner;

public class MainZeroSumSubarrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Zero Sum Subarrays:");
        ZeroSumSubarrayService.findZeroSumSubarrays(arr);

        scanner.close();
    }
}