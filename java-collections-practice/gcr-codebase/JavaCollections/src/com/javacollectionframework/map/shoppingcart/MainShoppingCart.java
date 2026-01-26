package com.javacollectionframework.map.shoppingcart;

import java.util.Scanner;

public class MainShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CartManager manager = new CartManager();

        while (true) {
            System.out.println("\nShopping Cart Menu");
            System.out.println("1. Add Product to System");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. Display Cart in Order Added");
            System.out.println("4. Display Cart Sorted by Price");
            System.out.println("5. Display All Products");
            System.out.println("6. Remove Item from Cart");
            System.out.println("7. Display Total Cost");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter product name: ");
                    String product = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    manager.addProduct(product, price);
                }
                case 2 -> {
                    System.out.print("Enter product name to add to cart: ");
                    String product = sc.nextLine();
                    manager.addToCart(product);
                }
                case 3 -> manager.displayCartInOrder();
                case 4 -> manager.displayCartSortedByPrice();
                case 5 -> manager.displayAllProducts();
                case 6 -> {
                    System.out.print("Enter product name to remove from cart: ");
                    String product = sc.nextLine();
                    manager.removeFromCart(product);
                }
                case 7 -> System.out.println("Total cart cost: $" + manager.getTotalCost());
                case 8 -> {
                    System.out.println("Exiting Shopping Cart...");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
