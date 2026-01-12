package com.tourmate;

class DomesticTrip extends Trip {

    public DomesticTrip(
            String destination,
            double budget,
            int duration,
            Transport transport,
            Hotel hotel,
            Activity activity
    ) {
        super(destination, budget, duration, transport, hotel, activity);
    }

    @Override
    public void book() {
        double totalCost = calculateTotalCost();

        if (totalCost <= budget) {
            System.out.println("Domestic trip to " + destination + " booked successfully.");
            System.out.println("Total Cost: ₹" + totalCost);
        } else {
            System.out.println("Budget exceeded for domestic trip.");
        }
    }

    @Override
    public void cancel() {
        System.out.println("Domestic trip to " + destination + " cancelled.");
    }
}
