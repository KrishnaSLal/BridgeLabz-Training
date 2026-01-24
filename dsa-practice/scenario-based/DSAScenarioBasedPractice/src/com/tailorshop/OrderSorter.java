package com.tailorshop;

public class OrderSorter {

    public static void insertionSort(Order[] orders) {

        for (int i = 1; i < orders.length; i++) {

            Order key = orders[i];
            int j = i - 1;

            while (j >= 0 && orders[j].getDeliveryDeadline() > key.getDeliveryDeadline()) {
                orders[j + 1] = orders[j];
                j--;
            }

            orders[j + 1] = key;
        }
    }
}
