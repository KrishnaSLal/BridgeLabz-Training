/*19. Bus Route Distance Tracker 🚌
Each stop adds distance.
● Ask if the passenger wants to get off at a stop.
● Use a while-loop with a total distance tracker.
● Exit on user confirmation.*/








import java.util.Scanner;

public class BusRouteDistanceTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double totalDistance = 0;
        int stopNumber = 1;
        String choice = "no";

        while (choice.equalsIgnoreCase("no")) {

            System.out.print("Enter distance covered till Stop " + stopNumber + " (in km): ");
            double distance = sc.nextDouble();

            totalDistance += distance;

            System.out.println("Total distance travelled: " + totalDistance + " km");

            System.out.print("Do you want to get off at this stop? (yes/no): ");
            choice = sc.next();

            stopNumber++;
        }

        System.out.println("Passenger got off.");
        System.out.println("Final distance travelled: " + totalDistance + " km");

        sc.close();
    }
}
