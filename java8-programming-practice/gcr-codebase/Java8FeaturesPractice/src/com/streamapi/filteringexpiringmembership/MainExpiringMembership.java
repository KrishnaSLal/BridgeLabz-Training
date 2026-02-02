//Filtering Expiring Memberships
//Given a list of gym members with their membership expiry dates, use Stream API to filter
//out members whose membership expires within the next 30 days.

package com.streamapi.filteringexpiringmembership;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class GymMember {
    int id;
    String name;
    LocalDate expiryDate;

    GymMember(int id, String name, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.expiryDate = expiryDate;
    }

    LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Member ID: " + id +
               ", Name: " + name +
               ", Expiry Date: " + expiryDate;
    }
}

public class MainExpiringMembership {
    public static void main(String[] args) {

        List<GymMember> members = Arrays.asList(
                new GymMember(1, "Rahul", LocalDate.now().plusDays(10)),
                new GymMember(2, "Anita", LocalDate.now().plusDays(45)),
                new GymMember(3, "Suresh", LocalDate.now().plusDays(25)),
                new GymMember(4, "Meena", LocalDate.now().plusDays(5))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        List<GymMember> expiringSoon =
                members.stream()
                       .filter(m -> !m.getExpiryDate().isBefore(today)
                                 && !m.getExpiryDate().isAfter(next30Days))
                       .collect(Collectors.toList());

        System.out.println("Memberships expiring within next 30 days:");
        expiringSoon.forEach(System.out::println);
    }
}
