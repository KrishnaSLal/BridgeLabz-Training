import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Take input for number of students
        System.out.print("Enter number of students: ");
        int number = input.nextInt();

        //Arrays to store marks, percentage, grade, and remarks
        int[][] marks = new int[number][3];   // 0-Physics, 1-Chemistry, 2-Maths
        double[] percentage = new double[number];
        char[] grade = new char[number];
        String[] remarks = new String[number];

        //User input for marks
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

            for (int j = 0; j < 3; j++) {
                System.out.print(
                        (j == 0 ? "Physics" : j == 1 ? "Chemistry" : "Maths") + ": ");
                int mark = input.nextInt();

                // Validate marks
                if (mark < 0) {
                    System.out.println("Invalid marks! Enter positive values.");
                    j--; // re-enter same subject
                    continue;
                }

                marks[i][j] = mark;
            }
        }

        //Calculate percentage, grade, and remarks
        for (int i = 0; i < number; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
                remarks[i] = "Level 4, above agency-normalized standards";
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
                remarks[i] = "Level 3, at agency-normalized standards";
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
                remarks[i] = "Level 2, below but approaching agency-normalized standards";
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
                remarks[i] = "Level 1, well below agency-normalized standards";
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
                remarks[i] = "Level 1-, too below agency-normalized standards";
            } else {
                grade[i] = 'R';
                remarks[i] = "Remedial standards";
            }
        }

        //Output
        System.out.println("Student Result Summary");
        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Maths: " + marks[i][2]);
            System.out.println("Percentage: " + percentage[i]);
            System.out.println("Grade: " + grade[i]);
            System.out.println("Remarks: " + remarks[i]);
        }

        input.close();
    }
}
