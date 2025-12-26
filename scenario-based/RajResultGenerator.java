import java.util.Scanner;

public class RajResultGenerator{

    public static void main(String[] args) {
        //Scanner object named 'scanner' as requested
        Scanner scanner = new Scanner(System.in);

        int totalSubjects = 5;
        int[] marks = new int[totalSubjects];
        int sum = 0;

        // Input marks using for-loop
        System.out.println("Enter marks for " + totalSubjects + " subjects:");
        for (int i = 0; i < totalSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            sum += marks[i];
        }

        // Calculate average
        double average = sum / (double) totalSubjects;
        System.out.println("\nAverage Marks: " + average);

        // Assign grade using switch
        char grade;
        switch ((int) average / 10) {
            case 10: // 100
            case 9:  grade = 'A'; break; // 90–99
            case 8:  grade = 'B'; break; // 80–89
            case 7:  grade = 'C'; break; // 70–79
            case 6:  grade = 'D'; break; // 60–69
            default: grade = 'F'; break; // Below 60
        }

        System.out.println("Final Grade: " + grade);

        scanner.close();
    }
}