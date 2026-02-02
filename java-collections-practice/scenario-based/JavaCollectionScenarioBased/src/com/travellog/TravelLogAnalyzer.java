package com.travellog;

import java.util.*;
import java.util.regex.*;

public class TravelLogAnalyzer {

    // Regex search for cities inside experience text
    public static Set<String> findCitiesUsingRegex(List<Trip> trips) {

        Set<String> cities = new HashSet<>();
        Pattern pattern = Pattern.compile("\\b([A-Z][a-z]+)\\b");

        for (Trip trip : trips) {
            Matcher matcher = pattern.matcher(trip.getExperience());
            while (matcher.find()) {
                cities.add(matcher.group());
            }
        }
        return cities;
    }

    // Trips longer than 5 days
    public static List<Trip> longTrips(List<Trip> trips) {
        List<Trip> result = new ArrayList<>();
        for (Trip t : trips) {
            if (t.getDurationInDays() > 5) {
                result.add(t);
            }
        }
        return result;
    }

    // Unique countries visited
    public static Set<String> uniqueCountries(List<Trip> trips) {
        Set<String> countries = new HashSet<>();
        for (Trip t : trips) {
            countries.add(t.getCountry());
        }
        return countries;
    }

    // Top 3 most visited cities
    public static List<Map.Entry<String, Integer>>
    top3Cities(List<Trip> trips) {

        Map<String, Integer> cityCount = new HashMap<>();

        for (Trip t : trips) {
            cityCount.put(t.getCity(),
                    cityCount.getOrDefault(t.getCity(), 0) + 1);
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(cityCount.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        return list.subList(0, Math.min(3, list.size()));
    }
}
