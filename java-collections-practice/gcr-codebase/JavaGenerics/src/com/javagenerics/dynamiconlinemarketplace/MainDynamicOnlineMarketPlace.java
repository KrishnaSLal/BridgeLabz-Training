package com.javagenerics.dynamiconlinemarketplace;

import java.util.*;

public class MainDynamicOnlineMarketPlace {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductCatalog catalog = new ProductCatalog();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nProduct " + i);
            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Discount (%): ");
            double discount = sc.nextDouble();
            sc.nextLine();

            System.out.println("Select Category:");
            System.out.println("1. Book");
            System.out.println("2. Clothing");
            System.out.println("3. Gadget");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                Product<BookCategory> p = new Product<>(name, price, new BookCategory());
                Discount.applyDiscount(p, discount);
                catalog.addProduct(p);
            } else if (choice == 2) {
                Product<ClothingCategory> p = new Product<>(name, price, new ClothingCategory());
                Discount.applyDiscount(p, discount);
                catalog.addProduct(p);
            } else if (choice == 3) {
                Product<GadgetCategory> p = new Product<>(name, price, new GadgetCategory());
                Discount.applyDiscount(p, discount);
                catalog.addProduct(p);
            } else {
                System.out.println("Invalid category");
                i--;
            }
        }

        System.out.println("\nProduct Catalog:");
        catalog.displayProducts();

        sc.close();
    }
}