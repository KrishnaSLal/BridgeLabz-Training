import java.util.Scanner;

public class StudentVoteCheck{

    // Method to check if a student can vote
    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false; // Invalid age
        } else if (age >= 18) {
            return true;  // Eligible to vote
        } else {
            return false; // Not eligible
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array to store ages of 10 students
        int[] ages = new int[10];

     // Array to store voting eligibility (true/false)
        boolean[] canVoteArray = new boolean[10];

        int eligibleCount = 0;
        int notEligibleCount = 0;

        // Loop to take input and check voting eligibility
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = input.nextInt();

            // Call method to check voting eligibility
            canVoteArray[i] = canStudentVote(ages[i]);

            // Count eligible and not eligible
            if (ages[i] < 0) {
                System.out.println("Invalid age entered. Student cannot vote.");
                notEligibleCount++;
            } else if (canVoteArray[i]) {
                System.out.println("Student " + (i + 1) + " with age " + ages[i] + " CAN vote.");
                eligibleCount++;
            } else {
                System.out.println("Student " + (i + 1) + " with age " + ages[i] + " CANNOT vote.");
                notEligibleCount++;
            }
        }

        //output
        System.out.println("Voting Eligibility of the students: ");
        System.out.println("Total students: " + ages.length);
        System.out.println("Eligible to vote: " + eligibleCount);
        System.out.println("Not eligible to vote: " + notEligibleCount);

        input.close();
    }
}