package com.junit.com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    public String formatDate(String inputDate) {
        if (inputDate == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        try {
            LocalDate date = LocalDate.parse(inputDate);
            return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format or value");
        }
    }
}
