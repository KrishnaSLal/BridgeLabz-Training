package com.eventease;

import java.util.List;

public class ConferenceEvent extends Event {

    public ConferenceEvent(String eventName, String location, String date, List<String> attendees) {
        super(eventName, location, date, attendees);
    }

    public ConferenceEvent(String eventName, String location, String date, List<String> attendees,
                           double cateringCost, double decorationCost) {
        super(eventName, location, date, attendees, cateringCost, decorationCost);
    }

    @Override
    public void schedule() {
        System.out.println("Conference Event '" + eventName + "' scheduled professionally on " + date);
    }

    @Override
    public void reschedule(String newDate) {
        System.out.println("Conference Event '" + eventName + "' rescheduled from " + date + " to " + newDate);
        this.date = newDate;
    }

    @Override
    public void cancel() {
        System.out.println("Conference Event '" + eventName + "' has been canceled due to unforeseen circumstances.");
    }
}
