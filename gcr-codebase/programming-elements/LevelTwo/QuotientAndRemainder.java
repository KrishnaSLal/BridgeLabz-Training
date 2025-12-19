import java.util.Scanner;
public class QuotientAndRemainder{
       public static void main(String[]args){
	   
	     Scanner input = new Scanner(System.in);
		 
		 System.out.print("Enter the divident: ");
		 float number1 = input.nextFloat();
		 
		 System.out.print("Enter the divisor: ");
		 float number2 = input.nextFloat();
		 
         //Calculations: Quotient = a/b , Remainder = a%b 		 
		 float Quotient = number1/number2;
		 float Remainder = number1%number2;
		 
		 System.out.print("The Quotient is " + Quotient + " and Reminder is " + Remainder + " of two number "+ number1+" and "+ number2);
		 
		 input.close();
		 
	   }
}