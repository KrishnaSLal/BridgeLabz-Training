package com.callcenter;

import java.util.*;

public class CallCenterManager {

    private Queue<Customer> normalQueue;
    private PriorityQueue<Customer> vipQueue;
    private HashMap<Integer, Integer> callCountMap;

    public CallCenterManager() {
        normalQueue = new LinkedList<>();
        vipQueue = new PriorityQueue<>();
        callCountMap = new HashMap<>();
    }

    // Add incoming call
    public void addCall(Customer customer) {

        // Update call count
        callCountMap.put(
                customer.getId(),
                callCountMap.getOrDefault(customer.getId(), 0) + 1
        );

        // Add to appropriate queue
        if (customer.isVIP()) {
            vipQueue.add(customer);
        } else {
            normalQueue.add(customer);
        }
    }

    // Serve next customer
    public void serveNextCustomer() {
        Customer servedCustomer;

        if (!vipQueue.isEmpty()) {
            servedCustomer = vipQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            servedCustomer = normalQueue.poll();
        } else {
            System.out.println("No customers in queue.");
            return;
        }

        System.out.println("Serving: " + servedCustomer);
    }

    // Display call statistics
    public void displayCallStats() {
        System.out.println("\nCustomer Call Count This Month:");
        for (Map.Entry<Integer, Integer> entry : callCountMap.entrySet()) {
            System.out.println("Customer ID " + entry.getKey()
                    + " -> Calls: " + entry.getValue());
        }
    }
}
