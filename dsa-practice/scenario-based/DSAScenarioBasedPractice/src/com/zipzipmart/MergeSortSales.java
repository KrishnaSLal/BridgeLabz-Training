package com.zipzipmart;

import java.util.List;
import java.util.ArrayList;

public class MergeSortSales {

    public static List<SaleTransaction> mergeSort(List<SaleTransaction> sales) {
        if (sales.size() <= 1) {
            return sales;
        }

        int mid = sales.size() / 2;

        List<SaleTransaction> left = mergeSort(sales.subList(0, mid));
        List<SaleTransaction> right = mergeSort(sales.subList(mid, sales.size()));

        return merge(left, right);
    }

    private static List<SaleTransaction> merge(
            List<SaleTransaction> left,
            List<SaleTransaction> right) {

        List<SaleTransaction> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {

            // Sort by date first, then by amount (stable)
            if (left.get(i).getDate().isBefore(right.get(j).getDate()) ||
               (left.get(i).getDate().isEqual(right.get(j).getDate()) &&
                left.get(i).getAmount() <= right.get(j).getAmount())) {

                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }
}
