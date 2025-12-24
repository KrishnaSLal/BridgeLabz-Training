import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic{
    
    // Method to perform the required date arithmetic
    public static LocalDate calculateNewDate(LocalDate inputDate) {
        // Step 1: Add 7 days, 1 month, and 2 years
        LocalDate modifiedDate = inputDate.plusDays(7)
                                          .plusMonths(1)
                                          .plusYears(2);
        
        // Step 2: Subtract 3 weeks
        modifiedDate = modifiedDate.minusWeeks(3);
        
        return modifiedDate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input in ISO format (YYYY-MM-DD)
        System.out.print("Enter a date (YYYY-MM-DD): ");
        String dateInput = scanner.nextLine();
        
        LocalDate inputDate = LocalDate.parse(dateInput);
        LocalDate resultDate = calculateNewDate(inputDate);
        
        // Professional output formatting
        System.out.println("\n--- Date Arithmetic Result ---");
        System.out.println("Original Date : " + inputDate);
        System.out.println("Final Date    : " + resultDate);
        
        scanner.close();
    }
}