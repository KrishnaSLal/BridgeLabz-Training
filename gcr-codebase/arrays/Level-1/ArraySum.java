import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {

        double[] numbers = new double[10];

        double total = 0.0;

        int index = 0;

        Scanner input = new Scanner(System.in);

        // Infinite while loop
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double value = input.nextDouble();

            // Break if user enters 0 or a negative number
            if (value <= 0) {
                break;
            }

            // Break if array size reaches 10
            if (index == 10) {
                break;
            }

            // Store value in array and increment index
            numbers[index] = value;
            index++;
        }

        // Display numbers and calculate total
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }
        //Output
        System.out.println("\nSum of all numbers: " + total);

        input.close();
    }
}