package com.objectmodeling.libraryandbooks;

public class AggregationDemo {
    public static void main(String[] args) {

        // Books created independently
        Book book1 = new Book("Java Basics", "James Gosling");
        Book book2 = new Book("Clean Code", "Robert C. Martin");
        Book book3 = new Book("Effective Java", "Joshua Bloch");

        // Two libraries
        Library centralLibrary = new Library("Central Library");
        Library collegeLibrary = new Library("College Library");

        // Same books added to different libraries
        centralLibrary.addBook(book1);
        centralLibrary.addBook(book2);

        collegeLibrary.addBook(book2);
        collegeLibrary.addBook(book3);

        // Display books
        centralLibrary.showBooks();
        collegeLibrary.showBooks();
    }
}

