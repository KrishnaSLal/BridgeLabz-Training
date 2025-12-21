import java.util.Scanner;

public class FootballTeamHeights{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] heights = new int[11];

        // Take input from user
        readHeights(input, heights);

        // Display heights
        System.out.println("Heights of players (in cm):");
        for (int h : heights) {
            System.out.print(h + " ");
        }

        // Method calls
        int sum = findSum(heights);
        double mean = findMean(heights);
        int minimum = findShortest(heights);
        int maximum = findTallest(heights);

        //Results
        System.out.println("Sum of heights = " + sum);
        System.out.println("Mean height = " + mean);
        System.out.println("Minimum height = " + minimum);
        System.out.println("Maximum height = " + maximum);

        input.close();
    }

    // Method to read heights from user
    public static void readHeights(Scanner input, int[] heights) {
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height (in cm) for player " + (i + 1) + ": ");
            heights[i] = input.nextInt();
        }
    }

    // Method to find sum of heights
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int h : heights) {
            sum += h;
        }
        return sum;
    }

    // Method to find mean height
    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    // Method to find shortest height
    public static int findShortest(int[] heights) {
        int minimum = heights[0];
        for (int h : heights) {
            if (h < minimum) {
                minimum = h;
            }
        }
        return minimum;
    }

    // Method to find tallest height
    public static int findTallest(int[] heights) {
        int maximum = heights[0];
        for (int h : heights) {
            if (h > maximum) {
                maximum = h;
            }
        }
        return maximum;
    }
}
