package com.callcenter;

public class MainCallCenter {

    public static void main(String[] args) {

        CallCenterManager manager = new CallCenterManager();

        Customer c1 = new Customer(101, "Krishna S Lal", false);
        Customer c2 = new Customer(102, "Amit", true);
        Customer c3 = new Customer(101, "Krishna S Lal", false);
        Customer c4 = new Customer(101, "Krishna S Lal", true);

        manager.addCall(c1);
        manager.addCall(c2);
        manager.addCall(c3);
        manager.addCall(c4);

        manager.serveNextCustomer();
        manager.serveNextCustomer();
        manager.serveNextCustomer();

        manager.displayCallStats();
    }
}