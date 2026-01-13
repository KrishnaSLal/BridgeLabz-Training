package com.callcenter;

public class Customer implements Comparable<Customer> {

    private int id;
    private String name;
    private boolean isVIP;

    public Customer(int id, String name, boolean isVIP) {
        this.id = id;
        this.name = name;
        this.isVIP = isVIP;
    }

    public int getId() {
        return id;
    }

    public boolean isVIP() {
        return isVIP;
    }

    @Override
    public int compareTo(Customer other) {
        // VIP customers get higher priority
        return Boolean.compare(other.isVIP, this.isVIP);
    }

    @Override
    public String toString() {
        return "Customer{id=" + id +
                ", name='" + name + '\'' +
                ", VIP=" + isVIP + '}';
    }
}
