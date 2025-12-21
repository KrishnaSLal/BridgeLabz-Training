import java.util.Scanner;

public class BMICalculator{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[][] bmiData = new double[10][3]; // weight, height(cm), BMI
        String[] bmiStatus;

        // Method calls
        readInput(input, bmiData);
        calculateBMI(bmiData);
        bmiStatus = determineStatus(bmiData);
        displayResult(bmiData, bmiStatus);

        input.close();
    }

    // Method to read weight and height
    public static void readInput(Scanner input, double[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Enter weight (kg) for person " + (i + 1) + ":");
            data[i][0] = input.nextDouble();

            System.out.println("Enter height (cm) for person " + (i + 1) + ":");
            data[i][1] = input.nextDouble();
        }
    }

    // Method to calculate BMI
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double heightInMeters = data[i][1] / 100.0;
            data[i][2] = data[i][0] / (heightInMeters * heightInMeters);
        }
    }

    // Method to determine BMI status
    public static String[] determineStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    //result
    public static void displayResult(double[][] data, String[] status) {
        System.out.println("\nBMI Report:");
        System.out.printf("%-10s %-10s %-10s %-15s\n",
                "Weight", "Height", "BMI", "Status");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n",
                    data[i][0], data[i][1], data[i][2], status[i]);
        }
    }
}