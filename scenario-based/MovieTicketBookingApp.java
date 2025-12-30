/*14. Movie Ticket Booking App 🎬
Ask users for movie type, seat type (gold/silver), and snacks.
● Use switch and if together.
● Loop through multiple customers.
● Clean structure and helpful variable names.*/




import java.util.Scanner;

public class MovieTicketBookingApp {

    // Constants
    static final int ACTION_PRICE = 200;
    static final int COMEDY_PRICE = 150;
    static final int DRAMA_PRICE = 180;
    static final int GOLD_EXTRA = 100;
    static final int SILVER_EXTRA = 50;
    static final int SNACK_PRICE = 80;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char continueBooking = 'y';

        do {
            int ticketPrice = 0;
            int snackPrice = 0;

            System.out.println("\nWelcome to Movie Ticket Booking");

            System.out.print("Enter movie type (Action / Comedy / Drama): ");
            String movieType = scanner.next();

            System.out.print("Enter seat type (Gold / Silver): ");
            String seatType = scanner.next();

            System.out.print("Do you want snacks? (yes/no): ");
            String snacks = scanner.next();

            // Movie price selection
            switch (movieType.toLowerCase()) {
                case "action":
                    ticketPrice = ACTION_PRICE;
                    break;
                case "comedy":
                    ticketPrice = COMEDY_PRICE;
                    break;
                case "drama":
                    ticketPrice = DRAMA_PRICE;
                    break;
                default:
                    System.out.println("Invalid movie type");
                    continue;
            }

            // Seat price selection
            if (seatType.equalsIgnoreCase("gold")) {
                ticketPrice += GOLD_EXTRA;
            } else if (seatType.equalsIgnoreCase("silver")) {
                ticketPrice += SILVER_EXTRA;
            } else {
                System.out.println("Invalid seat type");
                continue;
            }

            // Snacks selection
            if (snacks.equalsIgnoreCase("yes")) {
                snackPrice = SNACK_PRICE;
            } else if (!snacks.equalsIgnoreCase("no")) {
                System.out.println("Invalid snacks option");
                continue;
            }

            int totalAmount = ticketPrice + snackPrice;

            System.out.println("\nBooking Summary");
            System.out.println("Movie Type : " + movieType);
            System.out.println("Seat Type  : " + seatType);
            System.out.println("Snacks     : " + snacks);
            System.out.println("Total Bill : " + totalAmount);

            System.out.print("\nBook ticket for next customer? (y/n): ");
            continueBooking = scanner.next().charAt(0);

        } while (continueBooking == 'y' || continueBooking == 'Y');

        System.out.println("\nThank you for using Movie Ticket Booking App");
        scanner.close();
    }
}