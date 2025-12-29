import java.util.Scanner;

public class ParkingLotGateSystem {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        int capacity = 8;
        int occupied = 3;
        int choice;

        while (true) {

            System.out.println("Parking Lot Gate System: ");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Exit System");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    if (occupied < capacity) {
                        occupied++;
                        System.out.println("Vehicle parked successfully.");
                    } else {
                        System.out.println("Parking lot is FULL!");
                        System.out.println("System shutting down.");
                        input.close();
                        return;
                    }
                    break;

                case 2:
                    if (occupied > 0) {
                        occupied--;
                        System.out.println("Vehicle exited successfully.");
                    } else {
                        System.out.println("Parking lot is already EMPTY!");
                    }
                    break;

                case 3:
                    System.out.println("Occupied Slots: " + occupied);
                    System.out.println("Available Slots: " + (capacity - occupied));
                    break;

                case 4:
                    System.out.println("Thank you! Exiting system.");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
