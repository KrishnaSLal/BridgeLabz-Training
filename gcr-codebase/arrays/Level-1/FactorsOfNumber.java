import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Initial maximum size for factors array
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // Finding factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {

                //Checking if the array is full or not 
                if (index == maxFactor) {
                    // Double the size
                    maxFactor = maxFactor * 2;
                    int[] temp = new int[maxFactor];

                    // Copy old values to new array
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }

                    // Assign new array
                    factors = temp;
                }

                // Store factor
                factors[index] = i;
                index++;
            }
        }

        //Output
        System.out.println("\nFactors of " + number + ":");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        input.close();
    }
}
