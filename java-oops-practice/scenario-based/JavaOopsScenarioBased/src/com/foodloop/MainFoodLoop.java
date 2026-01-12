package com.foodloop;

import java.util.*;


public class MainFoodLoop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<FoodItem> orderItems = new ArrayList<>();

        System.out.print("Enter number of food items to order: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nItem " + i + " details:");

            System.out.print("Enter item type (1-Veg, 2-NonVeg): ");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter item name: ");
            String name = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter available stock: ");
            int stock = sc.nextInt();

            FoodItem item;
            if (type == 1) {
                item = new VegItem(name, price, stock);
            } else {
                item = new NonVegItem(name, price, stock);
            }

            orderItems.add(item);
        }

        Order order = new Order(orderItems);

        System.out.println("\nPlacing order...");
        order.placeOrder();

        System.out.print("\nDo you want to cancel the order? (yes/no): ");
        sc.nextLine();
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            order.cancelOrder();
        }

        sc.close();
    }
}
