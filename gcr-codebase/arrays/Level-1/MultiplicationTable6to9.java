import java.util.Scanner;

public class MultiplicationTable6to9{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Define integer array to store results (6 to 9 i.e., 4 values)
        int[] multiplicationResult = new int[4];

        // Calculate multiplication table from 6 to 9
        int index = 0;
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[index] = number * i;
            index++;
        }

        // Display the result
        System.out.println("\nMultiplication Table:");
        index = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[index]);
            index++;
        }

        input.close();
    }
}
