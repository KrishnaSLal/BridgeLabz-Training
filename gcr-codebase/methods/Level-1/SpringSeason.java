import java.util.Scanner;

public class SpringSeason{

    // Method to check if the given date is in Spring Season
    public static boolean isSpringSeason(int month, int day) {
        // Spring starts March 20 and ends June 20
        if ((month == 3 && day >= 20 && day <= 31) ||   // March 20–31
            (month == 4 && day >= 1 && day <= 30) ||    // April
            (month == 5 && day >= 1 && day <= 31) ||    // May
            (month == 6 && day >= 1 && day <= 20)) {    // June 1–20
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter day (1-31): ");
        int day = input.nextInt();

        // Check and print result
        if (isSpringSeason(month, day)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }

       input.close();
    }
}