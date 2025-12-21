import java.util.Scanner;

public class UnitConvertor3 {

    // Convert Fahrenheit to Celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;  // Formula: (F - 32) * 5/9
    }

    // Convert Celsius to Fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;  // Formula: (C * 9/5) + 32
    }

    // Convert pounds to kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    // Convert kilograms to pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    // Convert gallons to liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    // Convert liters to gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Unit Converter Utility");
        System.out.println("Choose conversion type:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Pounds to Kilograms");
        System.out.println("4. Kilograms to Pounds");
        System.out.println("5. Gallons to Liters");
        System.out.println("6. Liters to Gallons");

        System.out.print("Enter your choice (1-6): ");
        int choice = input.nextInt();

        System.out.print("Enter value: ");
        double value = input.nextDouble();

        double result;

        if (choice == 1) {
            result = convertFahrenheitToCelsius(value);
            System.out.printf("%.2f °F = %.2f °C%n", value, result);
        } else if (choice == 2) {
            result = convertCelsiusToFahrenheit(value);
            System.out.printf("%.2f °C = %.2f °F%n", value, result);
        } else if (choice == 3) {
            result = convertPoundsToKilograms(value);
            System.out.printf("%.2f pounds = %.2f kilograms%n", value, result);
        } else if (choice == 4) {
            result = convertKilogramsToPounds(value);
            System.out.printf("%.2f kilograms = %.2f pounds%n", value, result);
        } else if (choice == 5) {
            result = convertGallonsToLiters(value);
            System.out.printf("%.2f gallons = %.2f liters%n", value, result);
        } else if (choice == 6) {
            result = convertLitersToGallons(value);
            System.out.printf("%.2f liters = %.2f gallons%n", value, result);
        } else {
            System.out.println("Invalid choice!");
        }

        input.close();
    }
}