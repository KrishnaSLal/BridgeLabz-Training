package com.tourmate;

abstract class Trip implements IBookable {

    protected String destination;
    protected double budget;
    protected int duration;

    protected Transport transport;
    protected Hotel hotel;
    protected Activity activity;

    public Trip(
            String destination,
            double budget,
            int duration,
            Transport transport,
            Hotel hotel,
            Activity activity
    ) {
        this.destination = destination;
        this.budget = budget;
        this.duration = duration;
        this.transport = transport;
        this.hotel = hotel;
        this.activity = activity;
    }

    protected double calculateTotalCost() {
        return transport.getCost()
                + hotel.getCost()
                + activity.getCost();   // operator usage
    }
}
