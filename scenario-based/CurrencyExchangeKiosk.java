/*18. Currency Exchange Kiosk 💱
Design a currency converter:
● Take INR amount and target currency.
● Use a switch to apply the correct rate.
● Ask if the user wants another conversion (do-while).*/ 




import java.util.Scanner;

public class CurrencyExchangeKiosk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter amount in INR: ");
            double inr = sc.nextDouble();

            System.out.println("Select target currency:");
            System.out.println("1. USD");
            System.out.println("2. EUR");
            System.out.println("3. GBP");
            System.out.println("4. JPY");

            System.out.print("Enter your choice: ");
            int currency = sc.nextInt();

            double convertedAmount = 0;

            switch (currency) {
                case 1:
                    convertedAmount = inr * 0.012; // USD
                    System.out.println("Converted amount in USD: " + convertedAmount);
                    break;

                case 2:
                    convertedAmount = inr * 0.011; // EUR
                    System.out.println("Converted amount in EUR: " + convertedAmount);
                    break;

                case 3:
                    convertedAmount = inr * 0.010; // GBP
                    System.out.println("Converted amount in GBP: " + convertedAmount);
                    break;

                case 4:
                    convertedAmount = inr * 1.60; // JPY
                    System.out.println("Converted amount in JPY: " + convertedAmount);
                    break;

                default:
                    System.out.println("Invalid currency choice!");
            }

            System.out.print("Do you want another conversion? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Thank you for using Currency Exchange Kiosk 💱");
        sc.close();
    }
}
