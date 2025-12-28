package com.constructor.level1;

class Book {

    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        title = "Game of Thrones";
        author = "George R. R. Martin";
        price = 500.0;
    }

    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void display() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : " + price);
        System.out.println();
    }

    public static void main(String[] args) {

        // Using default constructor
        Book book1 = new Book();
        book1.display();

        // Using parameterized constructor
        Book book2 = new Book("Clean Code", "Robert C. Martin", 499.0);
        book2.display();
    }
}