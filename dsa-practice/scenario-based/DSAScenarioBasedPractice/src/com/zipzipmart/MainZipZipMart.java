package com.zipzipmart;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainZipZipMart {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<SaleTransaction> sales = new ArrayList<>();

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Transaction " + (i + 1));

            System.out.print("Transaction ID: ");
            int id = sc.nextInt();

            System.out.print("Date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(sc.next());

            System.out.print("Amount: ");
            double amount = sc.nextDouble();

            sales.add(new SaleTransaction(id, date, amount));
        }

        System.out.println("\n📄 Unsorted Sales Records:");
        sales.forEach(System.out::println);

        List<SaleTransaction> sortedSales = MergeSortSales.mergeSort(sales);

        System.out.println("\nSorted Daily Sales Report (By Date & Amount):");
        sortedSales.forEach(System.out::println);

        sc.close();
    }
}
