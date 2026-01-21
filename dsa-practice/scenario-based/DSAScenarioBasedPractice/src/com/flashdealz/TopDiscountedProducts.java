package com.flashdealz;

public class TopDiscountedProducts {

    public static void quickSort(Products[] products, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(products, low, high);
            quickSort(products, low, pivotIndex - 1);
            quickSort(products, pivotIndex + 1, high);
        }
    }

    private static int partition(Products[] products, int low, int high) {

        double pivot = products[high].getDiscount();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // descending order
            if (products[j].getDiscount() >= pivot) {
                i++;
                swap(products, i, j);
            }
        }

        swap(products, i + 1, high);
        return i + 1;
    }

    private static void swap(Products[] products, int i, int j) {
        Products temp = products[i];
        products[i] = products[j];
        products[j] = temp;
    }
    
    
}
