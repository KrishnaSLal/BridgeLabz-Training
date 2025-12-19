import java.util.Scanner;
public class AreaOfTriangle{
       public static void main(String args[]){
	          
		  Scanner input = new Scanner(System.in);
		  
		  System.out.print("Enter the base of the triangle in cm: ");
		  double base = input.nextDouble();
		  System.out.print("Enter the height of the triangle in cm: ");
		  double height = input.nextDouble();
		  
		  //Calculations
		  double areaCM = 0.5 * base*height;
		  //Conversion of area from cm^2 to inch^2 and foot^2
		  double areaInch = areaCM/Math.pow(2.54,2);
		  double areaFoot = areaInch/Math.pow(12,2);
		  
		  System.out.println("Your Height in cm is "+ areaCM + "while in feet is "+ areaFoot + "and inches is "+ areaInch +".");
		  
		  input.close();
		  
	   }
}