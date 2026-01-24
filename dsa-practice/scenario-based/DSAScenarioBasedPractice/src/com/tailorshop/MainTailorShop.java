//9. TailorShop – Sorting Orders by Delivery Deadline (Insertion Sort)
//Story: At a tailor’s shop, new clothing orders are received every hour. Each order has a
//deadline, and the owner maintains a sorted list of orders by delivery date. Since each new
//order is inserted into a nearly sorted list, Insertion Sort is simple and fast.
//Concepts Involved:
//● Insertion Sort
//● Real-time updates
//● Deadline-based sorting

package com.tailorshop;

import java.util.Scanner;

public class MainTailorShop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();

        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Order " + (i + 1));

            System.out.print("Order ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Delivery Deadline: ");
            int deadline = sc.nextInt();

            orders[i] = new Order(id, name, deadline);
        }

        OrderSorter.insertionSort(orders);

        System.out.println("\nOrders Sorted by Delivery Deadline:");
        for (Order order : orders) {
            System.out.println(order);
        }

        sc.close();
    }
}
