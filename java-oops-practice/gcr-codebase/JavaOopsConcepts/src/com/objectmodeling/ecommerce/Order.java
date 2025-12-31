package com.objectmodeling.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderId;
    private List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to Order " + orderId);
    }

    public void showOrderDetails() {
        double total = 0;
        System.out.println("Order ID: " + orderId);

        for (Product product : products) {
            System.out.println(product.getName() + " - Rs." + product.getPrice());
            total += product.getPrice();
        }

        System.out.println("Total Amount: Rs." + total);
    }
}
