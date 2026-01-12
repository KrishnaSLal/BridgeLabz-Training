package com.searching.challengeproblem.linearandbinarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class LinearBinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Take array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // -------- Linear Search Part --------
        int missing = firstMissingPositive(arr.clone());
        System.out.println("First missing positive number: " + missing);

        // -------- Binary Search Part --------
        System.out.print("Enter target number to search: ");
        int target = sc.nextInt();

        Arrays.sort(arr); // required for binary search

        int index = binarySearch(arr, target);

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Target index: " + index);

        sc.close();
    }

    // Linear search for first missing positive
    public static int firstMissingPositive(int[] arr) {

        int n = arr.length;

        // Mark visited numbers
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val >= 1 && val <= n) {
                arr[val - 1] = -Math.abs(arr[val - 1]);
            }
        }

        // Find first positive index
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Binary search
    public static int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
