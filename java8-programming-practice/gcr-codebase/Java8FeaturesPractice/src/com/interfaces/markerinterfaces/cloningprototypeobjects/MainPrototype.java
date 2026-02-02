package com.interfaces.markerinterfaces.cloningprototypeobjects;

public class MainPrototype {
    public static void main(String[] args) {

        try {
            Product original = new Product(101, "Laptop");

            // Clone the object
            Product copy = (Product) original.clone();

            System.out.println("Original Object: " + original);
            System.out.println("Cloned Object  : " + copy);

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }
    }
}
