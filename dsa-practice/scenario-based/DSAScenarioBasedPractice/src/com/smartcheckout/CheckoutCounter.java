package com.smartcheckout;

import java.util.LinkedList;
import java.util.Queue;

public class CheckoutCounter {

    private Queue<Customer> queue = new LinkedList<>();
    private Inventory inventory;

    public CheckoutCounter(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addCustomer(Customer customer) {
        queue.add(customer);
        System.out.println(customer.customerName + " added to billing queue.");
    }

    public void processCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue!");
            return;
        }

        Customer customer = queue.poll();
        double total = 0;

        System.out.println("\nBilling: " + customer.customerName);

        for (String itemName : customer.items) {
            Item item = inventory.getItem(itemName);

            if (item != null && item.stock > 0) {
                total += item.price;
                inventory.updateStock(itemName, 1);
                System.out.println(itemName + " - ₹" + item.price);
            } else {
                System.out.println(itemName + " - Out of stock!");
            }
        }

        System.out.println("Total Bill: ₹" + total);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
