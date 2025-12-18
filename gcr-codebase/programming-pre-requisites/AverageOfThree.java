import java.util.Scanner;
public class AverageOfThree{
       public static void main(String[]args){

      Scanner At = new Scanner(System.in);
	  System.out.print("Enter the first number: ");
	  double num1 = At.nextDouble();
	  System.out.print("Enter the second number: ");
	  double num2 = At.nextDouble();
	  System.out.print("Enter the third number: ");
	  double num3 = At.nextDouble();
	  
	  //Average of 3 numbers = (a+b+c)/3.
	  double output = (num1 + num2 + num3)/3;
	  System.out.print("The average of the given three numbers is : " + output);
	  
}
}