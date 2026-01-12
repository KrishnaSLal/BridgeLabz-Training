package com.tourmate;

class InternationalTrip extends Trip {

    public InternationalTrip(
            String destination,
            double budget,
            int duration,
            Transport transport,
            Hotel hotel,
            Activity activity
    ) {
        super(destination, budget, duration, transport, hotel, activity);
    }

    private double visaCharges() {
        return 7000;
    }

    @Override
    public void book() {
        double totalCost = calculateTotalCost() + visaCharges();

        if (totalCost <= budget) {
            System.out.println("International trip to " + destination + " booked successfully.");
            System.out.println("Total Cost (with visa): ₹" + totalCost);
        } else {
            System.out.println("Budget exceeded for international trip.");
        }
    }

    @Override
    public void cancel() {
        System.out.println("International trip to " + destination + " cancelled with visa refund rules.");
    }
}
