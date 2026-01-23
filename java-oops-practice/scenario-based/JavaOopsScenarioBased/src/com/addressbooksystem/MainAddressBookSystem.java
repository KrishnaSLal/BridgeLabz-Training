//Address Book System
//OOP Concepts:
//Classes, Objects, Encapsulation, Constructors, Access Modifiers, Collections
//Scenario:
//You’ve been hired by DigiContact Pvt. Ltd., a startup creating digital tools for managing
//contacts and relationships. They want a simple but robust Address Book application.
//Each Contact should include:
//● First Name, Last Name
//● Phone Number, Email
//● Address (optional: City, State, Zip)
//Problem Statement:
//Develop a Java application that:
//● Adds a new contact (with validation for duplicates)
//● Edits an existing contact by name
//● Deletes a contact by name
//● Searches contacts by city or state
//● Displays all contacts sorted alphabetically
//● Stores contacts in an in-memory structure like ArrayList<Contact>
//Use:
//● Classes and constructors to initialize contacts
//● Encapsulation for secure data access
//● Optional use of composition (Address as a separate class)

package com.addressbooksystem;

import java.util.Scanner;

public class MainAddressBookSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddressBook book = new AddressBook();

        while (true) {
            System.out.println("\n1.Add  2.Edit  3.Delete  4.Search City  5.Display  6.Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("First Name: ");
                    String fn = sc.nextLine();

                    System.out.print("Last Name: ");
                    String ln = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("State: ");
                    String state = sc.nextLine();

                    System.out.print("Zip: ");
                    String zip = sc.nextLine();

                    book.addContact(
                        new Contact(fn, ln, phone, email,
                            new Address(city, state, zip))
                    );
                    break;

                case 2:
                    System.out.print("Enter First Name to edit: ");
                    fn = sc.nextLine();

                    System.out.print("New Phone: ");
                    phone = sc.nextLine();

                    System.out.print("New Email: ");
                    email = sc.nextLine();

                    System.out.print("New City: ");
                    city = sc.nextLine();

                    System.out.print("New State: ");
                    state = sc.nextLine();

                    System.out.print("New Zip: ");
                    zip = sc.nextLine();

                    book.editContact(fn, phone, email,
                            new Address(city, state, zip));
                    break;

                case 3:
                    System.out.print("Enter First Name to delete: ");
                    book.deleteContact(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter City: ");
                    book.searchByCity(sc.nextLine());
                    break;

                case 5:
                    book.displayAll();
                    break;

                case 6:
                    System.out.println("Exiting");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

