/*9. School Bus Attendance System 🚍
Track 10 students' presence.
● Use for-each loop on names.
● Ask "Present or Absent?"
● Print total present and absent counts.*/




import java.util.Scanner;

public class SchoolBusAttendanceSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Array of student names
        String[] students = {"Krishna", "Priyanshu", "Kartik", "Vaishnav", "Aryaman", re"Deepanshu", "Rudresh", "Soumya", "Rudra", "Sachin"};

        int presentCount = 0;
        int absentCount = 0;

        System.out.println("School Bus Attendance System");

        // for-each loop to check attendance
        for (String student : students) {
            System.out.print("Is " + student + " Present or Absent? ");
            String status = scanner.nextLine().trim();

            if (status.equalsIgnoreCase("Present")) {
                presentCount++;
            } else if (status.equalsIgnoreCase("Absent")) {
                absentCount++;
            } else {
                System.out.println("Invalid input! Marked as Absent by default.");
                absentCount++;
            }

            System.out.println("--------------------------------");
        }

        // Display totals
        System.out.println("Attendance Summary");
        System.out.println("Total Present Students : " + presentCount);
        System.out.println("Total Absent Students  : " + absentCount);

        scanner.close();
    }
}