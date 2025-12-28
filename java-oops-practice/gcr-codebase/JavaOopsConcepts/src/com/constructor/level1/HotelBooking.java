package com.constructor.level1;

public class HotelBooking {
	
	String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    void displayBooking() {
        System.out.println(
            "Guest Name: " + guestName +
            ", Room Type: " + roomType +
            ", Nights: " + nights
        );
    }

    public static void main(String[] args) {

        // Using default constructor
        HotelBooking booking1 = new HotelBooking();

        // Using parameterized constructor
        HotelBooking booking2 = new HotelBooking("Aryaman", "Deluxe", 3);

        // Using copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);

        booking1.displayBooking();
        booking2.displayBooking();
        booking3.displayBooking();
    }
}
