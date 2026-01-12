package com.tourmate;

class Hotel {

    private double hotelCostPerDay;
    private int days;

    public Hotel(double hotelCostPerDay, int days) {
        this.hotelCostPerDay = hotelCostPerDay;
        this.days = days;
    }

    double getCost() {
        return hotelCostPerDay * days;
    }
}
