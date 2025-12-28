package com.constructor.level1;

public class LibraryBook {

	String title;
    String author;
    double price;
    boolean available;

    // Constructor
    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true; // book is available when created
    }

    // Method to borrow a book
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Sorry, the book is already borrowed.");
        }
    }

    // Method to display book details
    void displayBook() {
        System.out.println(
            "Title: " + title +
            ", Author: " + author +
            ", Price: ₹" + price +
            ", Available: " + available
        );
    }

    public static void main(String[] args) {

        LibraryBook book1 = new LibraryBook(
            "Clean Code",
            "Robert C. Martin",
            450.0
        );

        book1.displayBook();
        book1.borrowBook();
        book1.displayBook();

        // Trying to borrow again
        book1.borrowBook();
    }
}
