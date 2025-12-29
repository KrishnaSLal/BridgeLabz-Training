import java.util.Scanner;

public class ShopkeepersDiscountDashboard {

    // Constants for discount rates
    private static final double DISCOUNT_10_PERCENT = 0.10;
    private static final double DISCOUNT_5_PERCENT = 0.05;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double totalBill = 0.0;
        double discount;
        double finalAmount;

        // Input number of items
        System.out.print("Enter number of items: ");
        int numberOfItems = scanner.nextInt();

        // Taking item prices using for-loop
        for (int i = 1; i <= numberOfItems; i++) {
            System.out.print("Enter price of item " + i + ": ");
            double price = scanner.nextDouble();
            totalBill += price;
        }

        // Discount logic using if-else
        if (totalBill >= 500) {
            discount = totalBill * DISCOUNT_10_PERCENT;
        } else if (totalBill >= 300) {
            discount = totalBill * DISCOUNT_5_PERCENT;
        } else {
            discount = 0.0;
        }

        // Final amount after discount
        finalAmount = totalBill - discount;

        // Display bill details
        System.out.println("Bill Summary: ");
        System.out.printf("Total Bill   : Rs.%.2f%n", totalBill);
        System.out.printf("Discount     : Rs.%.2f%n", discount);
        System.out.printf("Final Amount : Rs.%.2f%n", finalAmount);

        scanner.close();
    }
}