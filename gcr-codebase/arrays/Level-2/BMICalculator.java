import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Take input for number of persons
        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        // Arrays to store details
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        //Take input for weight and height
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Enter weight (kg): ");
            weight[i] = input.nextDouble();

            System.out.print("Enter height (meters): ");
            height[i] = input.nextDouble();
        }

        //Calculate BMI and determine status (as per table)
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        //Output
        System.out.println("BMI Report: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height: " + height[i] + " m");
            System.out.println("Weight: " + weight[i] + " kg");
            System.out.println("BMI: " + bmi[i]);
            System.out.println("Status: " + status[i]);
            System.out.println();
        }

        input.close();
    }
}
