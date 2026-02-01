package com.interfaces.staticmethodsininterface.dateformatutility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateFormatUtils {

    // Static method to format date
    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}
