import java.util.Scanner;

public class UnitConverter2 {

    // Convert yards to feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    // Convert feet to yards
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    // Convert meters to inches
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    // Convert inches to meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    // Convert inches to centimeters
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Unit Converter Utility");
        System.out.println("Choose conversion type:");
        System.out.println("1. Yards to Feet");
        System.out.println("2. Feet to Yards");
        System.out.println("3. Meters to Inches");
        System.out.println("4. Inches to Meters");
        System.out.println("5. Inches to Centimeters");

        System.out.print("Enter your choice (1-5): ");
        int choice = input.nextInt();

        System.out.print("Enter the value to convert: ");
        double value = input.nextDouble();

        double result;

        if (choice == 1) {
            result = convertYardsToFeet(value);
            System.out.printf("%.2f yards = %.2f feet%n", value, result);
        } else if (choice == 2) {
            result = convertFeetToYards(value);
            System.out.printf("%.2f feet = %.2f yards%n", value, result);
        } else if (choice == 3) {
            result = convertMetersToInches(value);
            System.out.printf("%.2f meters = %.2f inches%n", value, result);
        } else if (choice == 4) {
            result = convertInchesToMeters(value);
            System.out.printf("%.2f inches = %.2f meters%n", value, result);
        } else if (choice == 5) {
            result = convertInchesToCentimeters(value);
            System.out.printf("%.2f inches = %.2f centimeters%n", value, result);
        } else {
            System.out.println("Invalid choice!");
        }

        input.close();
    }
}