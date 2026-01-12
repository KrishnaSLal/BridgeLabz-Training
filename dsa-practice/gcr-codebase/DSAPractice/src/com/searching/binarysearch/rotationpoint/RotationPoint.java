package com.searching.binarysearch.rotationpoint;

import java.util.Scanner;

public class RotationPoint {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take array size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Take array elements (rotated sorted array)
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find rotation point
        int index = findRotationPoint(arr);

        // Output
        System.out.println("Rotation point index: " + index);
        System.out.println("Smallest element: " + arr[index]);

        sc.close();
    }

    // Binary search to find rotation point
    public static int findRotationPoint(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // index of smallest element
    }
}
