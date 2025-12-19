import java.util.Scanner;

public class Leap_Year {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year (>=1582): ");
        int year = input.nextInt();

        // Checking leap year with a single if condition
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year.");
        } else if (year < 1582) {
            System.out.println("The year must be 1582 or later (Gregorian calendar).");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        input.close();
    }
}
