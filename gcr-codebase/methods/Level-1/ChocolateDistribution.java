import java.util.Scanner;

public class ChocolateDistribution{

    // Method to find remainder and quotient
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;   // chocolates per child
        int remainder = number % divisor;  // leftover chocolates

        //return both values in an array
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //User input
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = input.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = input.nextInt();

        // Call method
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        //output
        System.out.println("Each child gets " + result[0] + " chocolates.");
        System.out.println("Remaining chocolates = " + result[1]);

        input.close();
    }
}