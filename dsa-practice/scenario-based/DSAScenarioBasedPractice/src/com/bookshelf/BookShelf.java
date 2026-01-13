package com.bookshelf;

import java.util.*;

class BookShelf {

    // Genre - list of Books
    private Map<String, LinkedList<Book>> catalog = new HashMap<>();

    // To avoid duplication
    private Set<String> isbnSet = new HashSet<>();

    // Add a book
    public void addBook(String genre, Book book) {
        if (isbnSet.contains(book.getIsbn())) {
            System.out.println("Duplicate book not allowed!");
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        isbnSet.add(book.getIsbn());

        System.out.println("Book added: " + book);
    }

    // Borrow (remove) a book
    public void borrowBook(String genre, String isbn) {
        LinkedList<Book> books = catalog.get(genre);

        if (books == null || books.isEmpty()) {
            System.out.println("No books available in this genre.");
            return;
        }

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                isbnSet.remove(isbn);
                System.out.println("Book borrowed: " + book);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Display catalog
    public void displayCatalog() {
        for (String genre : catalog.keySet()) {
            System.out.println("\nGenre: " + genre);
            for (Book book : catalog.get(genre)) {
                System.out.println("  " + book);
            }
        }
    }
}
