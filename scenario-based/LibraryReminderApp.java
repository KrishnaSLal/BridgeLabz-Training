/*15. Rohan’s Library Reminder App 📚
Rohan wants a fine calculator:
● Input return date and due date.
● If returned late, calculate fine: ₹5/day.
● Repeat for 5 books using for-loop.*/




import java.util.Scanner;

public class LibraryReminderApp {

    static final int FINE_PER_DAY = 5;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int bookCount = 1;
        int totalFine = 0;

        System.out.println("Rohan's Library Reminder App");

        // Loop for 5 books using while loop
        while (bookCount <= 5) {

            System.out.println("\nBook " + bookCount);

            System.out.print("Enter due date (day number): ");
            int dueDate = scanner.nextInt();

            System.out.print("Enter return date (day number): ");
            int returnDate = scanner.nextInt();

            int fine = calculateFine(dueDate, returnDate);
            totalFine += fine;

            if (fine > 0) {
                System.out.println("Fine for this book: " + fine);
            } else {
                System.out.println("No fine for this book");
            }

            bookCount++;
        }

        System.out.println("\nTotal fine for all books: " + totalFine);
        scanner.close();
    }

    // Method to calculate fine
    public static int calculateFine(int dueDate, int returnDate) {
        if (returnDate > dueDate) {
            int lateDays = returnDate - dueDate;
            return lateDays * FINE_PER_DAY;
        }
        return 0;
    }
}
