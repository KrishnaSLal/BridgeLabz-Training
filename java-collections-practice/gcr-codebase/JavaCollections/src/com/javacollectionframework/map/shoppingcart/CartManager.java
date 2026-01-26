package com.javacollectionframework.map.shoppingcart;

import java.util.*;

public class CartManager {
    private Map<String, Double> productPrices = new HashMap<>();           // Product -> Price (fast lookup)
    private Map<String, Double> cartItems = new LinkedHashMap<>();         // Maintain order of items added
    private TreeMap<Double, List<String>> priceSortedItems = new TreeMap<>(); // Sorted by price

    // Add a product to the system
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        System.out.println("Product added: " + product + " -> $" + price);
    }

    // Add item to cart
    public void addToCart(String product) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found!");
            return;
        }

        double price = productPrices.get(product);
        cartItems.put(product, price);

        // Update TreeMap for sorted price display
        priceSortedItems.computeIfAbsent(price, k -> new ArrayList<>()).add(product);

        System.out.println(product + " added to cart at $" + price);
    }

    // Display items in cart in the order added (LinkedHashMap)
    public void displayCartInOrder() {
        System.out.println("Items in cart (in order added):");
        cartItems.forEach((product, price) -> System.out.println(product + " -> $" + price));
    }

    // Display items sorted by price (TreeMap)
    public void displayCartSortedByPrice() {
        System.out.println("Items in cart sorted by price:");
        priceSortedItems.forEach((price, products) -> {
            for (String product : products) {
                System.out.println(product + " -> $" + price);
            }
        });
    }

    // Display all available products (HashMap)
    public void displayAllProducts() {
        System.out.println("Available products:");
        productPrices.forEach((product, price) -> System.out.println(product + " -> $" + price));
    }

    // Get total cost of cart
    public double getTotalCost() {
        return cartItems.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    // Remove item from cart
    public void removeFromCart(String product) {
        if (!cartItems.containsKey(product)) {
            System.out.println("Item not in cart!");
            return;
        }

        double price = cartItems.remove(product);
        List<String> productsAtPrice = priceSortedItems.get(price);
        productsAtPrice.remove(product);
        if (productsAtPrice.isEmpty()) {
            priceSortedItems.remove(price);
        }

        System.out.println(product + " removed from cart.");
    }
}
