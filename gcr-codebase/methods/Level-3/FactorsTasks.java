import java.util.Scanner;

public class FactorsTasks{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read number from user
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Find factors array
        int[] factors = findFactors(number);

        // Display factors
        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();

        // Call methods and display results
        System.out.println("Greatest Factor = " + findGreatestFactor(factors));
        System.out.println("Sum of Factors = " + findSumOfFactors(factors));
        System.out.println("Product of Factors = " + findProductOfFactors(factors));
        System.out.println("Product of Cube of Factors = " + findProductOfCubeOfFactors(factors));

        input.close();
    }

    // Method to find factors of a number and return them as an array
    public static int[] findFactors(int number) {
        int count = 0;

        // First loop to count factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        // Second loop to store factors in array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    // Method to find the greatest factor using factors array
    public static int findGreatestFactor(int[] factors) {
        int greatest = factors[0];
        for (int f : factors) {
            if (f > greatest) {
                greatest = f;
            }
        }
        return greatest;
    }

    // Method to find the sum of factors using factors array
    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    // Method to find the product of factors using factors array
    public static long findProductOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }

    // Method to find the product of the cube of factors using Math.pow()
    public static double findProductOfCubeOfFactors(int[] factors) {
        double product = 1;
        for (int f : factors) {
            product *= Math.pow(f, 3);
        }
        return product;
    }
}