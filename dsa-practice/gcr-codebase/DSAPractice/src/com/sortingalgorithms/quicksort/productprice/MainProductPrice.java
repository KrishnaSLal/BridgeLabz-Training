package com.sortingalgorithms.quicksort.productprice;

import java.util.Scanner;

public class MainProductPrice {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        QuickSort quickSort = new QuickSort();
        quickSort.sort(prices, 0, n - 1);

        System.out.println("\nSorted Product Prices (Ascending Order):");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        sc.close();
    }
}
