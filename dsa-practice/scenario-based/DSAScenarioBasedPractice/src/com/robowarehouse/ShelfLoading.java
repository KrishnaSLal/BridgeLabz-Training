package com.robowarehouse;

public class ShelfLoading {

    public static void insertionSort(PackageItem[] packages) {

        for (int i = 1; i < packages.length; i++) {
            PackageItem key = packages[i];
            int j = i - 1;

            // Shift heavier packages to the right
            while (j >= 0 && packages[j].getWeight() > key.getWeight()) {
                packages[j + 1] = packages[j];
                j--;
            }
            packages[j + 1] = key;
        }
    }
}
