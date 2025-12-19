import java.util.Scanner;
public class HeightConversion{
       public static void main(String[]args){
	   
	      Scanner input = new Scanner(System.in);
		  
		  System.out.print("Enter your height in cm : ");
		  double heightCM = input.nextFloat();
		  
		  //Calculations: 1 foot = 12 inches and 1 inch = 2.54 cm.
		  double heightInch = heightCM/2.54;
		  double heightFoot = heightInch/12;
		  
		  System.out.print("Your Height in cm is " +  heightCM + " while in feet is " + heightFoot + " and inches is " + heightInch + ".");
		  
		  input.close();

	   }
}