package com.constructor.level1;

// Parent class
public class Books {

    // Access modifiers
    public String ISBN;        // public
    protected String title;    // protected
    private String author;     // private

    // Constructor
    public Books(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public getter for author
    public String getAuthor() {
        return author;
    }

    // MAIN method (entry point)
    public static void main(String[] args) {

        EBook ebook =
                new EBook("978-0135166307", "Effective Java", "Joshua Bloch", "PDF");

        ebook.displayEBookDetails();

        // Modify private author using public method
        ebook.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}

// Subclass
class EBook extends Books {

    private String format;

    // Constructor
    public EBook(String ISBN, String title, String author, String format) {
        super(ISBN, title, author);
        this.format = format;
    }

    // Demonstrating access modifiers
    public void displayEBookDetails() {
        System.out.println("ISBN: " + ISBN);        // public
        System.out.println("Title: " + title);      // protected
        System.out.println("Author: " + getAuthor()); // private via method
        System.out.println("Format: " + format);
        System.out.println("---------------------------");
    }
}
