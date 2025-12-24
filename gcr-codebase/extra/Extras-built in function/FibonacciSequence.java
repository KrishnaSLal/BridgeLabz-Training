import java.util.Scanner;

public class FibonacciSequence {

    // Method to generate and print Fibonacci sequence
    public static void generateFibonacci(int terms) {
        int first = 0, second = 1;

        System.out.println("\n--- Fibonacci Sequence ---");
        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println(); // for clean line break
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Fibonacci Sequence Generator: ");
        System.out.print("Enter the number of terms: ");
        int terms = scanner.nextInt();

        if (terms <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
        } else {
            generateFibonacci(terms);
        }

        scanner.close();
    }
}