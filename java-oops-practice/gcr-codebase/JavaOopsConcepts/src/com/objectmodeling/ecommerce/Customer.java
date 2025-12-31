package com.objectmodeling.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String customerName;
    private List<Order> orders;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(customerName + " placed Order ID: " + order.getOrderId());
    }

    public void showOrders() {
        System.out.println("Orders placed by " + customerName + ":");

        for (Order order : orders) {
            order.showOrderDetails();
            System.out.println();
        }
    }
}
