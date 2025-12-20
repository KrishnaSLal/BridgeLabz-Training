import java.util.Scanner;

public class SmallestLargest {

    //Method to find smallest and largest of three numbers
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = number1;
        int largest = number1;

        //compare with number2
        if (number2 < smallest) {
            smallest = number2;
        }
        if (number2 > largest) {
            largest = number2;
        }

        //Compare with number3
        if (number3 < smallest) {
            smallest = number3;
        }
        if (number3 > largest) {
            largest = number3;
        }

        //Return both values in an array
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //User input
        System.out.print("Enter first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        System.out.print("Enter third number: ");
        int num3 = input.nextInt();

        //Call method
        int[] result = findSmallestAndLargest(num1, num2, num3);

        //Output
        System.out.println("Smallest number = " + result[0]);
        System.out.println("Largest number = " + result[1]);

        input.close();
    }
}