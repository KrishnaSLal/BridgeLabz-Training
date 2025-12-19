import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // user input for month and day in integer value
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter day (1-31): ");
        int day = input.nextInt();

        // Check Spring Season (March 20 to June 20)
        if ((month == 3 && day >= 20 && day <= 31) ||
            (month == 4 && day >= 1 && day <= 30) ||
            (month == 5 && day >= 1 && day <= 31) ||
            (month == 6 && day >= 1 && day <= 20)) {
            System.out.println("It is a Spring Season");
        } else {
            System.out.println("It is not a Spring Season");
        }

        input.close();
    }
}
