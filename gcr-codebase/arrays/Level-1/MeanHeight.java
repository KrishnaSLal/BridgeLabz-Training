import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //double array
        double[] heights = new double[11];

        double sum = 0.0;

        // Get input values from the user
        for (int i = 0; i < 11; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
            sum += heights[i];
        }

        // Calculation = sum of all elements / number of elements
        double mean = sum / 11;

        // Display mean height
        System.out.println(" Mean height of the football team: " + mean);

        input.close();
    }
}
