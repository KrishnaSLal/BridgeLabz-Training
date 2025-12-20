import java.util.Scanner;

public class OddEvenArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        // Checking natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number.");
            input.close();
            return;
        }

        //Arrays for odd and even numbers
        int size = number / 2 + 1;
        int[] odd = new int[size];
        int[] even = new int[size];

        // Index variables
        int oddIndex = 0;
        int evenIndex = 0;

        // Save odd and even numbers into respective arrays
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[evenIndex] = i;
                evenIndex++;
            } else {
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print odd numbers
        System.out.println(" Odd Numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }

        // Print even numbers
        System.out.println(" Even Numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }

        input.close();
    }
}