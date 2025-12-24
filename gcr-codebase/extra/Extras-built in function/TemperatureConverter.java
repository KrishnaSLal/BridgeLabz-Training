import java.util.Scanner;

public class TemperatureConverter {

    // Function to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    // Function to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    // Function to display results
    public static void displayResult(double input, double output, String conversionType) {
        System.out.println("Conversion Result: ");
        System.out.println("Input (" + conversionType + ") : " + input);
        System.out.println("Converted Value              : " + output);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter: ");
        System.out.println("Choose conversion type:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double f = scanner.nextDouble();
            double c = fahrenheitToCelsius(f);
            displayResult(f, c, "Fahrenheit");
        } else if (choice == 2) {
            System.out.print("Enter temperature in Celsius: ");
            double c = scanner.nextDouble();
            double f = celsiusToFahrenheit(c);
            displayResult(c, f, "Celsius");
        } else {
            System.out.println("Invalid choice. Please run the program again.");
        }

        scanner.close();
    }
}