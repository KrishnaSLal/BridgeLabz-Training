package com.addressbooksystem;

public class Contact implements Comparable<Contact> {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address;

    public Contact(String firstName, String lastName, String phone,
                   String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    // Setters
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int compareTo(Contact c) {
        return this.firstName.compareToIgnoreCase(c.firstName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +"\nPhone: " + phone +"\nEmail: " + email +"\nAddress: " + address +"\n-------------------------";
    }
}
