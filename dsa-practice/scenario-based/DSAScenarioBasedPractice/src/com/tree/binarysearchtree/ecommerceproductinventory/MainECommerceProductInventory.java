//Story: E-Commerce Product Inventory
//An online store categorizes products by SKU numbers.
//Scenarios:
//● 🔹 Scenario 1: Lookup — Customers search for a product using SKU.
//● 🔹 Scenario 2: Price Update — Admin updates products using SKU key.
//● 🔹 Scenario 3: Sorted List — Display all products in sorted SKU order.

package com.tree.binarysearchtree.ecommerceproductinventory;

import java.util.Scanner;

public class MainECommerceProductInventory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductInventoryBST inventory = new ProductInventoryBST();
        int choice;

        do {
            System.out.println("\n===== E-Commerce Inventory System =====");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product by SKU");
            System.out.println("3. Update Product Price");
            System.out.println("4. Display Products (Sorted by SKU)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter SKU: ");
                    int sku = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inventory.insert(sku, name, price);
                    System.out.println("Product added.");
                    break;

                case 2:
                    System.out.print("Enter SKU to search: ");
                    sku = sc.nextInt();
                    Product p = inventory.search(sku);
                    if (p != null)
                        System.out.println("Found → " + p.name + ", ₹" + p.price);
                    else
                        System.out.println("Product not found.");
                    break;

                case 3:
                    System.out.print("Enter SKU: ");
                    sku = sc.nextInt();
                    System.out.print("Enter new price: ");
                    price = sc.nextDouble();
                    if (inventory.updatePrice(sku, price))
                        System.out.println("Price updated.");
                    else
                        System.out.println("Product not found.");
                    break;

                case 4:
                    System.out.println("\n--- Product List (Sorted by SKU) ---");
                    inventory.displaySorted();
                    break;

                case 5:
                    System.out.println("Exiting inventory system.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
