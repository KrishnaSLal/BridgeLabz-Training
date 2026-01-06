package com.eventease;

import java.util.List;

public class BirthdayEvent extends Event {

    public BirthdayEvent(String eventName, String location, String date, List<String> attendees) {
        super(eventName, location, date, attendees);
    }

    public BirthdayEvent(String eventName, String location, String date, List<String> attendees,
                         double cateringCost, double decorationCost) {
        super(eventName, location, date, attendees, cateringCost, decorationCost);
    }

    @Override
    public void schedule() {
        System.out.println("Birthday Event '" + eventName + "' scheduled on " + date + " at " + location);
    }

    @Override
    public void reschedule(String newDate) {
        System.out.println("Birthday Event '" + eventName + "' rescheduled from " + date + " to " + newDate);
        this.date = newDate;
    }

    @Override
    public void cancel() {
        System.out.println("Birthday Event '" + eventName + "' has been canceled.");
    }
}
