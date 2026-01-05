package com.linkedlist.singlylinkedlist.inventorymanagementsystem;

import java.util.Scanner;

public class MainInventoryApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryList inv = new InventoryList();
        int ch;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item (Beginning)");
            System.out.println("2. Add Item (End)");
            System.out.println("3. Add Item (Position)");
            System.out.println("4. Remove Item");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort Inventory");
            System.out.println("10. Display Inventory");
            System.out.println("11. Exit");

            ch = sc.nextInt();

            switch (ch) {
                case 1, 2, 3 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    if (ch == 1) inv.addAtBeginning(id, name, qty, price);
                    else if (ch == 2) inv.addAtEnd(id, name, qty, price);
                    else {
                        System.out.print("Position: ");
                        inv.addAtPosition(sc.nextInt(), id, name, qty, price);
                    }
                }
                case 4 -> inv.removeById(sc.nextInt());
                case 5 -> inv.updateQuantity(sc.nextInt(), sc.nextInt());
                case 6 -> inv.searchById(sc.nextInt());
                case 7 -> inv.searchByName(sc.next());
                case 8 -> inv.totalValue();
                case 9 -> {
                    System.out.println("1.Name  2.Price");
                    int c = sc.nextInt();
                    System.out.println("1.Asc  2.Desc");
                    inv.sort(c, sc.nextInt() == 1);
                }
                case 10 -> inv.displayAll();
                case 11 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 11);

        sc.close();
    }
}
