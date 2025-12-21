import java.util.Scanner;

public class FactorsCalculator {

    //method to find factors and return them in an array
    public static int[] findFactors(int number) {
        // First loop: count factors
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        //Initializing an array with count
        int[] factors = new int[count];

        //Second loop: store factors
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    //method to calculate sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    //method to calculate product of factors
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    //Method to calculate sum of squares of factors
    public static int sumOfSquares(int[] factors) {
        int sumSquares = 0;
        for (int factor : factors) {
            sumSquares += Math.pow(factor, 2);
        }
        return sumSquares;
    }

    //main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Scanner name changed to 'input'

        //Take user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        //Find factors
        int[] factors = findFactors(number);

        //Output factors
        System.out.print("Factors of " + number + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        //Output
        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));

        input.close();
    }
}