package com.encapsulationandpolymorphism.librarymanagementsystem;

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}
abstract class LibraryItem {

    // Encapsulation: private fields
    private int itemId;
    private String title;
    private String author;

    // Sensitive borrower data (encapsulated)
    private String borrowerName;
    private boolean isAvailable = true;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method
    public abstract int getLoanDuration(); // in days

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
    }

    // Encapsulation for borrower data
    protected void setBorrower(String name) {
        this.borrowerName = name;
        this.isAvailable = false;
    }

    protected void clearBorrower() {
        this.borrowerName = null;
        this.isAvailable = true;
    }

    protected boolean isAvailable() {
        return isAvailable;
    }
}
