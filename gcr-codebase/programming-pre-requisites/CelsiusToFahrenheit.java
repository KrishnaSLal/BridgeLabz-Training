import java.util.Scanner;
public class CelsiusToFahrenheit{
public static void main(String args[]){
    
	
	  Scanner CF = new Scanner(System.in); 
	  System.out.print("Give the temperature in celsius for conversion: ");
	  float temperature = CF.nextFloat();
	  float Fahrenheit = (temperature * 9/5) + 32 ;
	  
	  
	  System.out.println("The given celsius in fahrenheit scale is : " + Fahrenheit);
	  CF.close();
	
}
}