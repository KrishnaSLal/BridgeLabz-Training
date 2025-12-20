import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Names of friends(given)
        String[] names = {"Amar", "Akbar", "Anthony"};

        //Arrays for age and height
        int[] ages = new int[3];
        double[] heights = new double[3];

        //User input
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for " + names[i]);

            System.out.print("Enter age: ");
            ages[i] = input.nextInt();

            System.out.print("Enter height: ");
            heights[i] = input.nextDouble();
        }
        //Take both index as zero for comparison with other values in the array( and loop from the second element)
        int youngestIndex = 0;
        int tallestIndex = 0;

        //Loop to find youngest and tallest
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }

            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        //Output
        System.out.println("Youngest Friend: " + names[youngestIndex] +
                           " (Age: " + ages[youngestIndex] + ")");

        System.out.println("Tallest Friend: " + names[tallestIndex] +
                           " (Height: " + heights[tallestIndex] + ")");

        input.close();
    }
}
