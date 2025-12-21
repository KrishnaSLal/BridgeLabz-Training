import java.util.Scanner;

public class GradeAndRemarks {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take number of students
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        // Generate PCM scores
        int[][] pcmScores = generatePCMScores(n);

        // Calculate total, average, percentage
        double[][] results = calculateResults(pcmScores);

        // Display scorecard
        displayScoreCard(pcmScores, results);

        input.close();
    }

    // Method to generate random 2-digit PCM scores
    public static int[][] generatePCMScores(int n) {
        int[][] scores = new int[n][3];

        for (int i = 0; i < n; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10;
            scores[i][1] = (int) (Math.random() * 90) + 10;
            scores[i][2] = (int) (Math.random() * 90) + 10;
        }
        return scores;
    }

    // Method to calculate total, average and percentage
    public static double[][] calculateResults(int[][] scores) {
        double[][] result = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }

    // Method to get grade based on percentage
    public static String getGrade(double percentage) {
        if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "R";
    }

    // Method to get remarks based on percentage
    public static String getRemarks(double percentage) {
        if (percentage >= 80)
          return "Level 4 (Above agency-normalized standards)";
        else if (percentage >= 70)
          return "Level 3 (At agency-normalized standards)";
        else if (percentage >= 60)
          return "Level 2 (Below but approaching agency-normalized standards)";
        else if (percentage >= 50)
          return "Level 1 (Well below agency-normalized standards)";
        else if (percentage >= 40)
          return "Level 1- (Too below agency-normalized standards)";
        else
          return "Remedial standards";
}

    // Method to display scorecard
    public static void displayScoreCard(int[][] scores, double[][] results) {

        System.out.println("\nStu\tPhy\tChem\tMath\tTotal\tAvg\tPer%\tGrade\tRemarks");

        for (int i = 0; i < scores.length; i++) {
            String grade = getGrade(results[i][2]);
            String remarks = getRemarks(results[i][2]);

            System.out.println((i + 1) + "\t" + scores[i][0] + "\t"+ scores[i][1] + "\t"+ scores[i][2] + "\t" + (int) results[i][0] + "\t"+ results[i][1] + "\t"+ results[i][2] + "\t"+ grade + "\t"+ remarks);
        }
    }
}
