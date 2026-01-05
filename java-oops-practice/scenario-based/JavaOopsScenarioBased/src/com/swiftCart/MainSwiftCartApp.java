package com.swiftCart;

import java.util.Scanner;

public class MainSwiftCartApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            sc.nextLine(); // consume newline

            System.out.print("\nEnter product name: ");
            String name = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            System.out.print("Enter type (1 = Perishable, 2 = Non-Perishable): ");
            int type = sc.nextInt();

            Product product;
            if (type == 1) {
                product = new PerishableProduct(name, price);
            } else {
                product = new NonPerishableProduct(name, price);
            }

            cart.addProduct(product, quantity);
        }

        System.out.print("\nEnter coupon amount: ");
        double coupon = sc.nextDouble();

        cart.applyDiscount(coupon);
        cart.generateBill();

        sc.close();
    }
}

