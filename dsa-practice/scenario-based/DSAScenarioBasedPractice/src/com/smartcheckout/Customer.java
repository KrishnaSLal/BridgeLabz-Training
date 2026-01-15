package com.smartcheckout;

import java.util.List;

public class Customer {
    String customerName;
    List<String> items;

    public Customer(String customerName, List<String> items) {
        this.customerName = customerName;
        this.items = items;
    }
}
