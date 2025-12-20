import java.util.Scanner;

public class QuotientRemainder{

    //Method to find remainder and quotient
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;   // division operator
        int remainder = number % divisor;  // modulus operator

        //return both values in an array
        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //User input
        System.out.print("Enter the number: ");
        int number = input.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = input.nextInt();

        //Call method
        int[] result = findRemainderAndQuotient(number, divisor);

        //Output
        System.out.println("Quotient = " + result[1]);
        System.out.println("Remainder = " + result[0]);

        input.close();
    }
}