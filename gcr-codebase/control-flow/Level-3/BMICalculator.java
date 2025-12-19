import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in kg: ");
        double weight = input.nextDouble();

        System.out.print("Enter height in cm: ");
        double heightCm = input.nextDouble();

        //Converting height from cm to meters
        double heightMeter = heightCm / 100;

        //Calculating BMI formula BMI = weight / (height * height)
        double bmi = weight / (heightMeter * heightMeter);

        // Step 4: Determining weight status
        String status;

        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        System.out.printf("BMI = %.2f\n", bmi);
        System.out.println("Weight Status: " + status);

        input.close();
    }
}
