package com.linkedlist.doublylinkedlist.librarymanagementsystem;

class Library {

    private BookNode head;
    private BookNode tail;

    // Add at beginning
    public void addAtBeginning(int id, String title, String author, String genre, boolean isAvailable) {
        BookNode newNode = new BookNode(id, title, author, genre, isAvailable);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add at end
    public void addAtEnd(int id, String title, String author, String genre, boolean isAvailable) {
        BookNode newNode = new BookNode(id, title, author, genre, isAvailable);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add at position
    public void addAtPosition(int pos, int id, String title, String author, String genre, boolean isAvailable) {
        if (pos == 1) {
            addAtBeginning(id, title, author, genre, isAvailable);
            return;
        }

        BookNode temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null) {
            addAtEnd(id, title, author, genre, isAvailable);
            return;
        }

        BookNode newNode = new BookNode(id, title, author, genre, isAvailable);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Remove by Book ID
    public void removeById(int id) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    // Search by Title
    public void searchByTitle(String title) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found with this title.");
    }

    // Search by Author
    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found by this author.");
    }

    // Update availability
    public void updateAvailability(int id, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    // Display all forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\nBooks (Forward):");
        BookNode temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // Display all reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\nBooks (Reverse):");
        BookNode temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // Count books
    public int countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Display a single book
    private void displayBook(BookNode b) {
        System.out.println("ID: " + b.bookId +
                ", Title: " + b.title +
                ", Author: " + b.author +
                ", Genre: " + b.genre +
                ", Available: " + (b.isAvailable ? "Yes" : "No"));
    }
}
