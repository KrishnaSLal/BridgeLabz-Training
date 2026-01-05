package com.sortingalgorithms.quicksort.productprice;

public class QuickSort {

    public void sort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            // Recursively sort elements before and after partition
            sort(prices, low, pivotIndex - 1);
            sort(prices, pivotIndex + 1, high);
        }
    }

    // Partition using last element as pivot
    private int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                // swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // place pivot in correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }
}
