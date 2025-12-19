import java.util.Scanner;
public class DistanceConverter{
       public static void main(String[]args){
	   
	      Scanner input = new Scanner(System.in);
		  
		  System.out.print("Enter the distance in feets: ");
		  double DistanceFeet = input.nextDouble();
		  
		  //Calculations: 1 mile = 1760 yards and 1 yard is 3 feet
          double DistanceYard = DistanceFeet/3;
		  double DistanceMile = DistanceYard/1760;
		  
		  System.out.print("The distance in foot is " + DistanceFeet + "while in yard is " + DistanceYard + "and mile is " + DistanceMile + "." );
		  
		  input.close();
	   }
}