import java.util.Scanner;

public class LeapYearChecker{

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        // Condition1: divisible by 4 and not divisible by 100
        boolean conditionOne = (year % 4 == 0) && (year % 100 != 0);

        // Condition2: divisible by 400
        boolean conditionTwo = (year % 400 == 0);

        // Leap year if condition1 or condition2 is true
        return conditionOne || conditionTwo;
    }

    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take user year input
        System.out.print("Enter a year (>= 1582): ");
        int year = input.nextInt();

        // Check Gregorian calendar validity
        if (year < 1582) {
            System.out.println("Leap year calculation is valid only for year >= 1582 (Gregorian calendar).");
        } else {
            // Check leap year
            if (isLeapYear(year)) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is NOT a Leap Year.");
            }
        }

        input.close();
    }
}