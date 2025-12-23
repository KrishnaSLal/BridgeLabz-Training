import java.util.Scanner;

public class VotingEligibility{

    // Method to take age input for 10 students
    public static int[] getStudentAges() {

        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }

        return ages;
    }

    // Method to check voting eligibility
    // Returns 2D array: [age, canVote(true/false)]
    public static String[][] checkVotingEligibility(int[] ages) {

        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayResult(String[][] data) {

        System.out.println("\nAge\tCan Vote");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {

        // Number of students is constant
        int[] ages = getStudentAges();

        // Check voting eligibility
        String[][] votingResult = checkVotingEligibility(ages);

        // Display result
        displayResult(votingResult);
    }
}