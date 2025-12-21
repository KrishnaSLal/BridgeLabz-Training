import java.util.Scanner;

public class Calendar{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read month and year from user
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter year: ");
        int year = input.nextInt();

        // Display calendar
        displayCalendar(month, year);

        input.close();
    }

    // Method to display the calendar
    public static void displayCalendar(int month, int year) {

        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);

        // Print month and year
        System.out.println("\n    " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // First loop for indentation before the 1st day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Second loop to print all days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);

            // Move to next line after Saturday
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // Method to get month name
    public static String getMonthName(int month) {
        String[] months = {
                "", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return months[month];
    }

    // Method to get number of days in a month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {
                0, 31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month];
    }

    // Method to check leap year
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // Method to find the first day of the month (Gregorian calendar)
    public static int getFirstDayOfMonth(int month, int year) {
        int day = 1;
        int y = year - 1;

        int totalDays = y * 365 + y / 4 - y / 100 + y / 400;

        for (int i = 1; i < month; i++) {
            totalDays += getDaysInMonth(i, year);
        }

        return (totalDays + day) % 7;
    }
}