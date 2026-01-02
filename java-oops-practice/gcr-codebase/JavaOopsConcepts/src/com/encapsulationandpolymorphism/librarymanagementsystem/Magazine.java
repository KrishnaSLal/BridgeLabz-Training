package com.encapsulationandpolymorphism.librarymanagementsystem;

class Magazine extends LibraryItem implements Reservable {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine is currently unavailable");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}
