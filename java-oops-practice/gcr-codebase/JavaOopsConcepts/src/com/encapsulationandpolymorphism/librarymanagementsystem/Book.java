package com.encapsulationandpolymorphism.librarymanagementsystem;

class Book extends LibraryItem implements Reservable {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book is currently unavailable");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}
