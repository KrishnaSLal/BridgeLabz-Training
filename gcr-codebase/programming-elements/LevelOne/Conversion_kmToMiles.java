import java.util.Scanner;
public class Conversion_kmToMiles{
       public static void main(String[]mains){
       
	   Scanner input = new Scanner(System.in);
	   //Taking the input
	   System.out.print("Enter the distance in kilometer: ");
	   double kilometer = input.nextDouble();
       
       //Calculating km to miles
	   double miles = kilometer/1.6;
       System.out.print("The total miles is " + miles +  " mile for the given " + kilometer +"km");
     
       input.close();	 
     }
}