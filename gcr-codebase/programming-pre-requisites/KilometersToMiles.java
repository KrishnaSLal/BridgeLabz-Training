import java.util.Scanner;
public class KilometersToMiles{
public static void main(String[]args){

      Scanner KM = new Scanner(System.in);
	  System.out.print("Enter the distance in kilometers for conversion to miles: ");
	  double kilometers = KM.nextDouble();
	  //FORMULA: Miles = Kilometers * 0.621371.
	  
	 Double Miles = kilometers *  0.621371;
	 System.out.print("The given distance in miles = " + Miles);
}
}