import java.util.Scanner;

public class ElectionBoothManager{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vote counters
        int candidate1 = 0, candidate2 = 0, candidate3 = 0;

        while (true) {
            System.out.print("\nEnter age of voter (or -1 to exit): ");
            int age = scanner.nextInt();

            // Exit condition
            if (age == -1) {
                break;
            }

            // Check eligibility
            if (age < 18) {
                System.out.println("Not eligible to vote.");
                continue; // Skip to next voter
            }

            // Record vote
            System.out.println("Eligible! Cast your vote:");
            System.out.println("1. Candidate A");
            System.out.println("2. Candidate B");
            System.out.println("3. Candidate C");
            System.out.print("Enter your choice (1/2/3): ");
            int vote = scanner.nextInt();

            switch (vote) {
                case 1: candidate1++; break;
                case 2: candidate2++; break;
                case 3: candidate3++; break;
                default: System.out.println("Invalid vote!"); break;
            }
        }

        // Final results
        System.out.println("Voting Results:");
        System.out.println("Candidate A: " + candidate1 + " votes");
        System.out.println("Candidate B: " + candidate2 + " votes");
        System.out.println("Candidate C: " + candidate3 + " votes");

        scanner.close();
    }
}