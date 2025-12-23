import java.util.Scanner;

public class GradeAndRemarks{

    // Method to take PCM scores from user
    public static int[][] getPCMScores(int students) {

        Scanner sc = new Scanner(System.in);
        int[][] pcm = new int[students][3];

        for (int i = 0; i < students; i++) {
            System.out.println("Enter marks for Student " + (i + 1));

            System.out.print("Physics: ");
            pcm[i][0] = sc.nextInt();

            System.out.print("Chemistry: ");
            pcm[i][1] = sc.nextInt();

            System.out.print("Maths: ");
            pcm[i][2] = sc.nextInt();
        }
        return pcm;
    }

    // Method to calculate Total, Average, Percentage
    public static double[][] calculateResults(int[][] pcm) {

        double[][] result = new double[pcm.length][3];

        for (int i = 0; i < pcm.length; i++) {

            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round to 2 digits
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }

        return result;
    }

    // Method to calculate Grade and Remarks
    public static String[][] calculateGradeRemarks(double[][] result) {

        String[][] gradeRemarks = new String[result.length][2];

        for (int i = 0; i < result.length; i++) {

            double percent = result[i][2];

            if (percent >= 80) {
                gradeRemarks[i][0] = "A";
                gradeRemarks[i][1] = "Level 4, above agency-normalized standards";
            } else if (percent >= 70) {
                gradeRemarks[i][0] = "B";
                gradeRemarks[i][1] = "Level 3, at agency-normalized standards";
            } else if (percent >= 60) {
                gradeRemarks[i][0] = "C";
                gradeRemarks[i][1] = "Level 2, below but approaching agency-normalized standards";
            } else if (percent >= 50) {
                gradeRemarks[i][0] = "D";
                gradeRemarks[i][1] = "Level 1, well below agency-normalized standards";
            } else if (percent >= 40) {
                gradeRemarks[i][0] = "E";
                gradeRemarks[i][1] = "Level 1-, too below agency-normalized standards";
            } else {
                gradeRemarks[i][0] = "R";
                gradeRemarks[i][1] = "Remedial standards";
            }
        }
        return gradeRemarks;
    }

    // Method to display Scorecard
    public static void displayScoreCard(
            int[][] pcm,
            double[][] result,
            String[][] gradeRemarks) {

        System.out.println("\nScore Card");
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade\tRemarks");

        for (int i = 0; i < pcm.length; i++) {
            System.out.println((i + 1) + "\t" +pcm[i][0] + "\t" +pcm[i][1] + "\t" +pcm[i][2] + "\t" +(int) result[i][0] + "\t" +result[i][1] + "\t" +result[i][2] + "\t" +gradeRemarks[i][0] + "\t" + gradeRemarks[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] pcmScores = getPCMScores(students);
        double[][] results = calculateResults(pcmScores);
        String[][] gradeRemarks = calculateGradeRemarks(results);

        displayScoreCard(pcmScores, results, gradeRemarks);
    }
}
