import java.util.Scanner;

public class MetroSmartCard{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial balance
        double balance = 500.0;  // Example starting balance

        while (true) {
            System.out.println("\nCurrent Balance: Rs." + balance);

            // Exit condition if balance is exhausted
            if (balance <= 0) {
                System.out.println("Balance exhausted. Please recharge your card.");
                break;
            }

            System.out.print("Enter distance travelled in km (or -1 to quit): ");
            int distance = scanner.nextInt();

            // Exit condition
            if (distance == -1) {
                System.out.println("Thank you for using Delhi Metro Smart Card!");
                break;
            }

            // Fare calculation using ternary operator
            double fare = (distance <= 5) ? 10.0 : 
                          (distance <= 10) ? 20.0 : 
                          (distance <= 20) ? 30.0 : 40.0;

            // Deduct fare if balance is sufficient
            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare deducted: Rs." + fare);
                System.out.println("Remaining Balance: Rs." + balance);
            } else {
                System.out.println("Insufficient balance for this trip. Please recharge.");
                break;
            }
        }

        scanner.close();
    }
}