package com.inheritance.singleinheritance.librarymanagement;

public class MainLibrary {

    public static void main(String[] args) {

        Author bookWithAuthor = new Author(
                "Java Programming",
                2023,
                "James Gosling",
                "Creator of the Java programming language"
        );

        bookWithAuthor.displayInfo();
    }
}
