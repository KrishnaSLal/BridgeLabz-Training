package com.encapsulationandpolymorphism.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class MainLibraryManagementSystem {

    public static void main(String[] args) {

        List<LibraryItem> items = new ArrayList<>();

        LibraryItem b1 = new Book(1, "Effective Java", "Joshua Bloch");
        LibraryItem m1 = new Magazine(2, "Tech Monthly", "Editorial Team");
        LibraryItem d1 = new DVD(3, "Inception", "Christopher Nolan");

        items.add(b1);
        items.add(m1);
        items.add(d1);

        for (LibraryItem item : items) {

            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                r.reserveItem("Rahul");
                System.out.println("Available after reservation: " + r.checkAvailability());
            }

            System.out.println("----------------------------");
        }
    }
}
