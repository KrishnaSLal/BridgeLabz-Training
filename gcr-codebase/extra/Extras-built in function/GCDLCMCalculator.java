import java.util.Scanner;

public class GCDLCMCalculator{

    // Function to calculate GCD using Euclidean Algorithm
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM using GCD
    public static int calculateLCM(int a, int b) {
        return (a * b) / calculateGCD(a, b);
    }

    // Function to display results
    public static void displayResult(int a, int b, int gcd, int lcm) {
        System.out.println("GCD and LCM Result: ");
        System.out.println("Numbers entered : " + a + " and " + b);
        System.out.println("GCD             : " + gcd);
        System.out.println("LCM             : " + lcm);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("GCD and LCM Calculator: ");
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2);

        displayResult(num1, num2, gcd, lcm);

        scanner.close();
    }
}