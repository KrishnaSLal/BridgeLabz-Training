package com.runtimeanalysis.searchingtarget;

import java.util.Arrays;
import java.util.Scanner;

public class SearchTargetInLargeDataset {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter count of numbers: ");
        int count = input.nextInt();
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = i;
        }

        System.out.print("Enter number to search between 0 - " + count + ": ");
        int target = input.nextInt();

        long startLinear = System.nanoTime();
        int linearIndex = -1;

        for (int i = 0; i < count; i++) {
            if (arr[i] == target) {
                linearIndex = i;
                break;
            }
        }

        long endLinear = System.nanoTime();

        if (linearIndex != -1)
            System.out.println("Linear Search → Target found at index: " + linearIndex);
        else
            System.out.println("Linear Search → Not found");

        System.out.println("Time of Linear Search: " + (endLinear - startLinear) + " ns");


        Arrays.sort(arr);

        long startBinary = System.nanoTime();
        int start = 0, end = arr.length - 1;
        int binaryIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                binaryIndex = mid;
                break;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        long endBinary = System.nanoTime();

        if (binaryIndex != -1)
            System.out.println("Binary Search → Target found at sorted index: " + binaryIndex);
        else
            System.out.println("Binary Search → Not found");

        System.out.println("Time of Binary Search: " + (endBinary - startBinary) + " ns");

        input.close();
    }
}