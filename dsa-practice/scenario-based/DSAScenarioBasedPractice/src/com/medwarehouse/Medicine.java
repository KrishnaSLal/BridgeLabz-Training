package com.medwarehouse;

public class Medicine {

    private int medicineId;
    private String name;
    private int expiryDays;

    public Medicine(int medicineId, String name, int expiryDays) {
        this.medicineId = medicineId;
        this.name = name;
        this.expiryDays = expiryDays;
    }

    public int getExpiryDays() {
        return expiryDays;
    }

    @Override
    public String toString() {
        return "Medicine ID: " + medicineId +", Name: " + name + ", Expiry in: " + expiryDays + " days";
    }
}
