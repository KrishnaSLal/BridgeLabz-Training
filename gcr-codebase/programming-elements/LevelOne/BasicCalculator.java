import java.util.Scanner;
public class BasicCalculator{
       public static void main(String[]args){
    
	      Scanner input = new Scanner(System.in);
	
	      System.out.print("Enter the first number for calculations: ");
		  float number1 = input.nextFloat();
		  
		   System.out.print("Enter the second number for calculations: ");
		   float number2 = input.nextFloat();
		   
		   //Arithematic calculations (+,-,*,/).
		   float Addition = number1 + number2;
		   float Subtraction = number1 - number2;
		   float Multiplication = number1 * number2;
		   float Division = number1 / number2;
		   
		   System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + number1 + "and" + number2 +" is " + Addition + "," + Subtraction +"," +  Multiplication + "," + Division + ".");
		   
		   input.close();
	}
}