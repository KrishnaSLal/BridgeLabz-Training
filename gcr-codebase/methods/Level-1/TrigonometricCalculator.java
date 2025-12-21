import java.util.Scanner;

public class TrigonometricCalculator {

    //method to calculate sine, cosine, and tangent
    public static double[] calculateTrigonometricFunctions(double angle) {
        // Convert angle to radians
        double radians = Math.toRadians(angle);

        //calculating trigonometric values
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        //return results in an array
        return new double[]{sine, cosine, tangent};
    }

    //main method to test the program
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //user input (angle)
        System.out.print("Enter angle in degrees: ");
        double angle = input.nextDouble();

        //calculate trignometric functions
        double[] results = calculateTrigonometricFunctions(angle);

        //Outpyt
        System.out.printf("Angle: %.2f°%n", angle);
        System.out.printf("Sine: %.4f%n", results[0]);
        System.out.printf("Cosine: %.4f%n", results[1]);
        System.out.printf("Tangent: %.4f%n", results[2]);

        input.close();
    }
}