import java.util.Scanner;

public class SmallestAndLargestNumber{

    //Method to find smallest and largest of three numbers
    public static void findSmallestLargest(int a, int b, int c) {
        int smallest, largest;

        //Start by assuming 'a' is both smallest and largest
        smallest = a;
        largest = a;

        //Compare with b
        if (b < smallest) {
            smallest = b;
        }
        if (b > largest) {
            largest = b;
        }

        //Compare with c
        if (c < smallest) {
            smallest = c;
        }
        if (c > largest) {
            largest = c;
        }

        //Print results
        System.out.println("Smallest number = " + smallest);
        System.out.println("Largest number = " + largest);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //take input from user
        System.out.print("Enter first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        System.out.print("Enter third number: ");
        int num3 = input.nextInt();

        //call method
        findSmallestLargest(num1, num2, num3);

        input.close();
    }
}