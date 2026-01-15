package com.smartshelf;

public class SmartShelf {

    Book[] books;
    int size;

    SmartShelf(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    // Add book and sort using Insertion Sort
    void addBook(Book newBook) {
        books[size] = newBook;
        size++;

        insertionSort();

        System.out.println(newBook.name + " added to the list");
    }

    // Insertion Sort by book title
    void insertionSort() {
        for (int i = 1; i < size; i++) {
            Book key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j].name.compareToIgnoreCase(key.name) > 0) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
        }
    }

    void displayBooks() {
        System.out.println("\nSorted Reading List:");
        for (int i = 0; i < size; i++) {
            books[i].display();
        }
    }
}
