import java.util.Scanner;

public class PhoneRechargeSimulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double balance = 0.0;
        char choice;

        System.out.println("Welcome to Phone Recharge Simulator");

        do {
            // Input operator
            System.out.println("Select Mobile Operator:");
            System.out.println("1. Jio");
            System.out.println("2. Airtel");
            System.out.println("3. VI");
            System.out.print("Enter your choice (1-3): ");
            int operator = scanner.nextInt();

            // Input recharge amount
            System.out.print("Enter recharge amount: Rs. ");
            double amount = scanner.nextDouble();

            // Add recharge amount to balance
            balance += amount;

            // Display offers using switch
            switch (operator) {
                case 1:
                    System.out.println("Jio Offer: Extra 1GB data valid for 1 day");
                    break;
                case 2:
                    System.out.println("Airtel Offer: Unlimited calls for 1 day");
                    break;
                case 3:
                    System.out.println("VI Offer: 100 SMS free today");
                    break;
                default:
                    System.out.println("Invalid operator selected");
            }

            // Display current balance
            System.out.printf("Current Balance: Rs.%.2f%n", balance);

            // Ask user to continue
            System.out.print("Do you want to recharge again? (y/n): ");
            choice = scanner.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Thank you for using Phone Recharge Simulator!");
        scanner.close();
    }
}
