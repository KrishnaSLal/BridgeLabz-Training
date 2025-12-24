import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {

    // Method to compare two dates
    public static void compareDates(LocalDate date1, LocalDate date2) {
        System.out.println("Date Comparison Result:");
        System.out.println("First Date  : " + date1);
        System.out.println("Second Date : " + date2);

        if (date1.isBefore(date2)) {
            System.out.println("Result      : First date is BEFORE the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("Result      : First date is AFTER the second date.");
        } else if (date1.isEqual(date2)) {
            System.out.println("Result      : Both dates are EQUAL.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input in ISO format (YYYY-MM-DD)
        System.out.print("Enter the first date (YYYY-MM-DD): ");
        String input1 = scanner.nextLine();
        LocalDate date1 = LocalDate.parse(input1);

        System.out.print("Enter the second date (YYYY-MM-DD): ");
        String input2 = scanner.nextLine();
        LocalDate date2 = LocalDate.parse(input2);

        // Compare the two dates
        compareDates(date1, date2);

        scanner.close();
    }
}