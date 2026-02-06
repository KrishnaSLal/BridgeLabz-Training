//Order Revenue Summary
//○ Scenario: Sum order totals per customer.
//○ Task: Use Collectors.summingDouble()


package com.collectors.orderrevenuesummary;

import java.util.*;
import java.util.stream.Collectors;

public class MainOrderRevenueSummary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();

        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Order " + (i + 1));

            System.out.print("Customer Name: ");
            String customer = sc.nextLine();

            System.out.print("Order Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            orders.add(new Order(customer, amount));
        }

        Map<String, Double> revenuePerCustomer =
                orders.stream()
                      .collect(Collectors.groupingBy(
                              Order::getCustomerName,
                              Collectors.summingDouble(Order::getAmount)
                      ));

        System.out.println("\nOrder Revenue Summary:");
        revenuePerCustomer.forEach((customer, total) ->
                System.out.println(customer + " - Rs." + total));

        sc.close();
    }
}
