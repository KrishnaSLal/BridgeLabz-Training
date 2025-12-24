import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Method to generate a random guess within the current range
    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    // Method to receive user feedback
    public static String getFeedback(Scanner sc, int guess) {
        System.out.print("Is the number " + guess + "? (Enter 'high', 'low', or 'correct'): ");
        return sc.nextLine().trim().toLowerCase();
    }

    // Method to adjust the range based on feedback
    public static int[] adjustRange(int low, int high, int guess, String feedback) {
        if (feedback.equals("high")) {
            high = guess - 1;  // number is lower
        } else if (feedback.equals("low")) {
            low = guess + 1;   // number is higher
        }
        return new int[]{low, high};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number Guessing Game: ");
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it");

        int low = 1, high = 100;
        boolean found = false;

        while (!found && low <= high) {
            int guess = generateGuess(low, high);
            String feedback = getFeedback(scanner, guess);

            if (feedback.equals("correct")) {
                System.out.println("I guessed your number: " + guess);
                found = true;
            } else if (feedback.equals("high") || feedback.equals("low")) {
                int[] newRange = adjustRange(low, high, guess, feedback);
                low = newRange[0];
                high = newRange[1];
            } else {
                System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }
        }

        if (!found) {
            System.out.println("It seems like something went wrong with the inputs.");
        }

        scanner.close();
    }
}

