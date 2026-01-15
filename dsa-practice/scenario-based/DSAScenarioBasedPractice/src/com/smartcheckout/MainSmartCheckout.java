package com.smartcheckout;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSmartCheckout {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        CheckoutCounter counter = new CheckoutCounter(inventory);

        // Preload inventory
        inventory.addItem("Milk", 50, 10);
        inventory.addItem("Bread", 30, 5);
        inventory.addItem("Eggs", 6, 20);

        int choice;

        do {
            System.out.println("\nSmart Checkout:");
            System.out.println("1. Add Customer");
            System.out.println("2. Process Customer");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    List<String> items = new ArrayList<>();
                    System.out.print("Enter number of items: ");
                    int count = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter item name: ");
                        items.add(sc.nextLine());
                    }

                    counter.addCustomer(new Customer(name, items));
                    break;

                case 2:
                    counter.processCustomer();
                    break;

                case 3:
                    System.out.println("Checkout closed.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}
