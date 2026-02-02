//Hospital Doctor Availability
//○ Scenario: Find doctors available on weekends and sort by specialty.
//○ Task: Use streams with filter() and sorted().

package com.streamapi.hospitaldoctoravailability;

import java.util.*;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    String getSpecialty() {
        return specialty;
    }

    boolean isAvailableOnWeekend() {
        return availableOnWeekend;
    }

    @Override
    public String toString() {
        return name + " | " + specialty;
    }
}

public class MainHospitalDoctorAvailability {
    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Kumar", "Cardiology", true),
                new Doctor("Dr. Mehta", "Orthopedics", false),
                new Doctor("Dr. Sharma", "Neurology", true),
                new Doctor("Dr. Rao", "Dermatology", true),
                new Doctor("Dr. Iyer", "Cardiology", false)
        );

        System.out.println("Doctors available on weekends:\n");

        doctors.stream()
                .filter(Doctor::isAvailableOnWeekend)   // weekend availability
                .sorted(Comparator.comparing(Doctor::getSpecialty)) // sort by specialty
                .forEach(System.out::println);
    }
}
