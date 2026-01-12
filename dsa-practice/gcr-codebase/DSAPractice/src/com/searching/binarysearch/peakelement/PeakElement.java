package com.searching.binarysearch.peakelement;

import java.util.Scanner;

public class PeakElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take array size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Take array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find peak element index
        int peakIndex = findPeak(arr);

        // Output
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);

        sc.close();
    }

    // Binary search to find a peak
    public static int findPeak(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Peak lies in right half
                left = mid + 1;
            } else {
                // Peak lies in left half (including mid)
                right = mid;
            }
        }
        return left; // Peak index
    }
}
