import java.util.Scanner;

public class TheCoffeeCounterChronicles{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Coffee prices (per cup)
        final double ESPRESSO_PRICE = 100.0;
        final double LATTE_PRICE = 150.0;
        final double CAPPUCCINO_PRICE = 120.0;
        final double AMERICANO_PRICE = 90.0;

        final double GST_RATE = 0.05; // 5% GST

        System.out.println("Menu:");
        System.out.println("1. Espresso - Rs. 100");
        System.out.println("2. Latte - Rs. 150");
        System.out.println("3. Cappuccino - Rs. 120");
        System.out.println("4. Americano - Rs. 90");
        System.out.println("Type 'exit' to stop ordering.");

        while (true) {
            System.out.print("Enter coffee type (espresso/latte/cappuccino/americano or exit): ");
            String coffeeType = input.nextLine().toLowerCase();

            if (coffeeType.equals("exit")) {
                System.out.println("Thank you for the visit.");
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();
           input.nextLine(); // consume newline

            double pricePerCup = 0.0;

            // Switch-case for coffee type
            switch (coffeeType) {
                case "espresso":
                    pricePerCup = ESPRESSO_PRICE;
                    break;
                case "latte":
                    pricePerCup = LATTE_PRICE;
                    break;
                case "cappuccino":
                    pricePerCup = CAPPUCCINO_PRICE;
                    break;
                case "americano":
                    pricePerCup = AMERICANO_PRICE;
                    break;
                default:
                    System.out.println("Invalid coffee type. Please try again.");
                    continue;
            }

            // Bill calculation
            double total = pricePerCup * quantity;
            double gst = total * GST_RATE;
            double finalBill = total + gst;

            // Professional output formatting
            System.out.println(" Bill Details : ");
            System.out.printf("Coffee: %s%n", coffeeType.substring(0,1).toUpperCase() + coffeeType.substring(1));
            System.out.printf("Quantity: %d%n", quantity);
            System.out.printf("Base Amount: Rs. %.2f%n", total);
            System.out.printf("GST (5%%): Rs. %.2f%n", gst);
            System.out.printf("Total Payable: Rs. %.2f%n", finalBill);
        }

        input.close();
    }
}