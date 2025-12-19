import java.util.Scanner;

public class Friends {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
		//initialization for age and height
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Input ages and heights
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = input.nextInt();

            System.out.print("Enter height (in cm) of " + names[i] + ": ");
            heights[i] = input.nextDouble();
        }

        // Finding the youngest friend
        int minAgeIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[minAgeIndex]) {
                minAgeIndex = i;
            }
        }

        // Finding the tallest friend
        int maxHeightIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > heights[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }

        System.out.println("The youngest friend is " + names[minAgeIndex] + " with age " + ages[minAgeIndex]);
        System.out.println("The tallest friend is " + names[maxHeightIndex] + " with height " + heights[maxHeightIndex] + " cm");

        input.close();
    }
}
