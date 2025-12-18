import java.util.Scanner;

public class PerimeterOfRectangle {
	public static void main(String[] args) {

		Scanner Pr = new Scanner(System.in);
		System.out.print("Enter the length: ");
		double length = Pr.nextDouble();
		System.out.print("Enter the breadth: ");
		double breadth = Pr.nextDouble();
		// Perimeter = 2 * (length + width).
		double perimeter = 2 * (length + breadth);
		System.out.print("The perimeter of the rectangle is " + perimeter);

	}
}