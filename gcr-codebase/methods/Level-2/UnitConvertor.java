import java.util.Scanner;

public class UnitConvertor {

    //convert kilometers to miles
    public static double convertKmToMiles(double km) {
        return km * 0.621371;  // 1 km = 0.621371 miles
    }

    //convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;  // 1 mile = 1.60934 km
    }

    //convert meters to feet
    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;  // 1 meter = 3.28084 feet
    }

    //convert feet to meters
    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;  // 1 foot = 0.3048 meters
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        //User input for conversion
        System.out.println("Unit Converter Utility");
        System.out.println("Choose conversion type:");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Miles to Kilometers");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");

        // Ask user for choice
        System.out.print("Enter your choice (1-4): ");
        int choice = input.nextInt();

        // Ask user for value to convert
        System.out.print("Enter value: ");
        double value = input.nextDouble();

        double result = 0;  // Variable to store conversion result

        // Perform conversion based on user choice
        if (choice == 1) {
            result = convertKmToMiles(value);
            System.out.printf("%.2f km = %.2f miles%n", value, result);
        } else if (choice == 2) {
            result = convertMilesToKm(value);
            System.out.printf("%.2f miles = %.2f km%n", value, result);
        } else if (choice == 3) {
            result = convertMetersToFeet(value);
            System.out.printf("%.2f meters = %.2f feet%n", value, result);
        } else if (choice == 4) {
            result = convertFeetToMeters(value);
            System.out.printf("%.2f feet = %.2f meters%n", value, result);
        } else {
            // If user enters invalid choice
            System.out.println("Invalid choice!");
        }

        input.close();  
    }
}