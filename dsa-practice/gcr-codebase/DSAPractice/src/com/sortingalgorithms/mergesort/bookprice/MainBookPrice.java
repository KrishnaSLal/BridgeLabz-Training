package com.sortingalgorithms.mergesort.bookprice;

import java.util.Scanner;

public class MainBookPrice {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(prices, 0, n - 1);

        System.out.println("\nSorted Book Prices (Ascending Order):");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        sc.close();
    }
}
