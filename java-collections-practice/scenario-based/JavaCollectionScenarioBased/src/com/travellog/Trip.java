package com.travellog;

import java.io.Serializable;

public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;

    private String city;
    private String country;
    private int durationInDays;
    private String experience;

    public Trip(String city, String country, int durationInDays, String experience) {
        this.city = city;
        this.country = country;
        this.durationInDays = durationInDays;
        this.experience = experience;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public String getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return city + ", " + country +
                " (" + durationInDays + " days)";
    }
}
