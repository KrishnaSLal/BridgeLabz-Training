import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Take input for number of persons
        System.out.print("Enter number of persons: ");
        int number = input.nextInt();

        // 2D array to store weight, height, BMI
        // index 0 -> weight
        // index 1 -> height
        // index 2 -> BMI
        double[][] personData = new double[number][3];

        //Array to store weight
        String[] weight = new String[number];

        //Take input for weight and height which are valid
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            //Weight input
            while (true) {
                System.out.print("Enter weight (kg): ");
                personData[i][0] = input.nextDouble();
                if (personData[i][0] > 0) {
                    break;
                }
                System.out.println("Invalid weight! Enter a positive value.");
            }

            //Height input
            while (true) {
                System.out.print("Enter height (meters): ");
                personData[i][1] = input.nextDouble();
                if (personData[i][1] > 0) {
                    break;
                }
                System.out.println("Invalid height! Enter a positive value.");
            }
        }

        // Calculate BMI 
        for (int i = 0; i < number; i++) {
            personData[i][2] =
                    personData[i][0] / (personData[i][1] * personData[i][1]);

            if (personData[i][2] <= 18.4) {
                weight[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weight[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weight[i] = "Overweight";
            } else {
                weight[i] = "Obese";
            }
        }

        //Output
        System.out.println("BMI Report");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Weight: " + personData[i][0] + " kg");
            System.out.println("Height: " + personData[i][1] + " m");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Status: " + weight[i]);
            System.out.println();
        }

        input.close();
    }
}

