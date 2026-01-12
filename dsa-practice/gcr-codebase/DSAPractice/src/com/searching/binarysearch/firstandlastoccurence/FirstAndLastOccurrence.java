package com.searching.binarysearch.firstandlastoccurence;

import java.util.Scanner;

public class FirstAndLastOccurrence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements (sorted)
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target element
        System.out.print("Enter target element: ");
        int target = sc.nextInt();

        // Find first and last occurrence
        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        // Output
        if (first == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("First occurrence index: " + first);
            System.out.println("Last occurrence index: " + last);
        }

        sc.close();
    }

    // Find first occurrence
    public static int findFirst(int[] arr, int target) {

        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // move left
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // Find last occurrence
    public static int findLast(int[] arr, int target) {

        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // move right
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
