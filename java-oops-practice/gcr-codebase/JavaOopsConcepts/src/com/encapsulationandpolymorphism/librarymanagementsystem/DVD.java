package com.encapsulationandpolymorphism.librarymanagementsystem;

class DVD extends LibraryItem implements Reservable {

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD is currently unavailable");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}
