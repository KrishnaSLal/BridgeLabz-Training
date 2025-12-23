import java.util.Scanner;

public class BMICalculator{

    // Method to calculate BMI and Status for one person
    public static String[] calculateBMI(double weight, double heightCm) {

        double heightMeter = heightCm / 100; // convert cm to meters
        double bmi = weight / (heightMeter * heightMeter);

        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[] {
            String.format("%.2f", heightCm),
            String.format("%.2f", weight),
            String.format("%.2f", bmi),
            status
        };
    }

    // Method to process all persons
    public static String[][] processBMI(double[][] data) {

        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            result[i] = calculateBMI(data[i][0], data[i][1]);
        }

        return result;
    }

    // Method to display result in tabular format
    public static void displayResult(String[][] result) {

        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                result[i][0] + "\t\t" +
                result[i][1] + "\t\t" +
                result[i][2] + "\t\t" +
                result[i][3]
            );
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[][] data = new double[10][2];

        // Taking user input
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));
            System.out.print("Weight (kg): ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Height (cm): ");
            data[i][1] = scanner.nextDouble();
        }

        // Processing and displaying result
        String[][] result = processBMI(data);
        displayResult(result);

        scanner.close();
    }
}
