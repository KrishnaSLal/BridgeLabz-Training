package com.addressbooksystem;

import java.util.ArrayList;
import java.util.Collections;

public class AddressBook {

    private ArrayList<Contact> contacts = new ArrayList<>();

    // Add contact with duplicate validation
    public void addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(contact.getFirstName())
                    && c.getLastName().equalsIgnoreCase(contact.getLastName())) {
                System.out.println("Contact already exists!");
                return;
            }
        }
        contacts.add(contact);
        System.out.println("Contact added successfully");
    }

    // Edit contact by first name
    public void editContact(String firstName, String newPhone, String newEmail, Address newAddress) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                c.setPhone(newPhone);
                c.setEmail(newEmail);
                c.setAddress(newAddress);
                System.out.println("Contact updated");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    // Delete contact by first name
    public void deleteContact(String firstName) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                contacts.remove(c);
                System.out.println("Contact deleted");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    // Search by city
    public void searchByCity(String city) {
        for (Contact c : contacts) {
            if (c.getAddress().getCity().equalsIgnoreCase(city)) {
                System.out.println(c);
            }
        }
    }

    // Search by state
    public void searchByState(String state) {
        for (Contact c : contacts) {
            if (c.getAddress().getState().equalsIgnoreCase(state)) {
                System.out.println(c);
            }
        }
    }

    // Display sorted contacts
    public void displayAll() {
        Collections.sort(contacts);
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}
