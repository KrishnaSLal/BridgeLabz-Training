import java.util.Scanner;
public class SquareLength{
       public static void main(String[]args){
	   
	      Scanner input = new Scanner(System.in);
		  
		  System.out.print("Enter the perimeter of the square: ");
		  double perimeter = input.nextDouble();
		  
		  //Calculation: Side of a square(when perimeter is given)= perimeter/4.
		  double side = perimeter/4;
		  
		  System.out.println("The length of the side is " + side +" whose perimeter is " + perimeter + ".");
		  
		  input.close();
		  
	   }
}