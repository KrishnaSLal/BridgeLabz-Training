package com.designpattern.librarymanagementsystem;

public class MainLibrary {
	public static void main(String[] args) {
		
		LibraryCatalog catalog = LibraryCatalog.getInstance();
		
		User student = UserFactory.createUser("student","Mohit");
		User faculty = UserFactory.createUser("faculty","Dr. bob");
		
		catalog.addObserver(student);
		catalog.addObserver(faculty);
		
		Book book1 = new Book.BookBuilder("Design Patterns")
							.author("GoF")
							.edition("2nd")
							.genre("Sofware Engineering")
							.build();
		
		catalog.addBook(book1);
	}
}