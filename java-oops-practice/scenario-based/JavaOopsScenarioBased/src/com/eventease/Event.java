package com.eventease;

import java.util.List;

public abstract class Event implements ISchedulable {

    protected String eventName;
    protected String location;
    protected String date;
    protected List<String> attendees;

    private final int eventId;           // access restricted
    private static int nextId = 1;

    private double venueCost;
    private double cateringCost;
    private double decorationCost;
    private double discount;

    public Event(String eventName, String location, String date, List<String> attendees) {
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;

        this.eventId = nextId++;
        this.venueCost = 1000;       // default cost
        this.cateringCost = 0;
        this.decorationCost = 0;
        this.discount = 0;
    }

    public Event(String eventName, String location, String date, List<String> attendees,
                 double cateringCost, double decorationCost) {
        this(eventName, location, date, attendees);
        this.cateringCost = cateringCost;
        this.decorationCost = decorationCost;
    }

    // Encapsulation: protected price getters
    protected double getTotalCost() {
        return (venueCost + cateringCost + decorationCost - discount);
    }

    protected void applyDiscount(double discount) {
        this.discount = discount;
    }

    public int getEventId() { return eventId; }

    public void displayEventDetails() {
        System.out.println("\n--- Event Details ---");
        System.out.println("Event Name: " + eventName);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Attendees: " + attendees.size());
        System.out.println("Total Cost: $" + getTotalCost());
    }
}
