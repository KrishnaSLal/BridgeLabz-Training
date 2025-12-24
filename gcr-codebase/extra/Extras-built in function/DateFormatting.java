import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting{

    // Method to display the date in different formats
    public static void displayFormattedDates(LocalDate date) {
        // Define formatters with custom patterns
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Print results with professional clarity
        System.out.println("Date Formatting Result");
        System.out.println("Format 1 (dd/MM/yyyy)     : " + date.format(format1));
        System.out.println("Format 2 (yyyy-MM-dd)     : " + date.format(format2));
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + date.format(format3));
    }

    public static void main(String[] args) {
        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Display in different formats
        displayFormattedDates(currentDate);
    }
}