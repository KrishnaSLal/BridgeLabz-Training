/*12. Train Reservation Queue 🚆
Simulate a basic ticket booking system.
● Show menu with switch
● Allow multiple bookings using while-loop.
● Stop booking once seats reach zero (break)*/




import java.util.Scanner;

public class TrainReservationQueue{

    // Total available seats
    private static final int TOTAL_SEATS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int availableSeats = TOTAL_SEATS;
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (availableSeats > 0) {
                        availableSeats--;
                        System.out.println("Ticket booked successfully!");
                        System.out.println("Remaining Seats: " + availableSeats);

                        if (availableSeats == 0) {
                            System.out.println("All seats are booked!");
                            break; // Stops booking when seats are zero
                        }
                    } else {
                        System.out.println("No seats available.");
                        isRunning = false;
                    }
                    break;

                case 2:
                    System.out.println("Available Seats: " + availableSeats);
                    break;

                case 3:
                    System.out.println("Exiting reservation system.");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

            if (availableSeats == 0) {
                System.out.println("Booking closed.");
                break;
            }
        }

        scanner.close();
    }

    // Method to display menu
    private static void displayMenu() {
        System.out.println("Train Reservation Menu: ");
        System.out.println("1. Book Ticket");
        System.out.println("2. View Available Seats");
        System.out.println("3. Exit");
    }
}
