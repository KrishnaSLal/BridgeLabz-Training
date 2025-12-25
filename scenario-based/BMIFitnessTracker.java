import java.util.Scanner;

public class BMIFitnessTracker {

    public static void main(String[] args) {

        // Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take height input in centimeters
        System.out.print("Enter height in centimeters: ");
        double heightInCm = scanner.nextDouble();

        // Take weight input in kilograms
        System.out.print("Enter weight in kilograms: ");
        double weightInKg = scanner.nextDouble();

        // Convert height from cm to meters
        double heightInMeters = heightInCm / 100;

        // Calculate BMI
        double bmi = weightInKg / (heightInMeters * heightInMeters);

        // Print BMI value up to 2 decimal places
        System.out.printf("Your BMI is: %.2f%n", bmi);

        // Determine BMI category
        if (bmi < 18.5) {
            System.out.println("BMI Category: Underweight");
        } else if (bmi < 25) {
            System.out.println("BMI Category: Normal");
        } else {
            System.out.println("BMI Category: Overweight");
        }


        scanner.close();
    }
}
