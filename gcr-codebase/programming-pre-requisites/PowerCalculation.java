import java.util.Scanner;
public class PowerCalculation{
public static void main(String[]args){
      
	 Scanner Pc = new Scanner(System.in);
	 System.out.print("Enter the base number: ");
	 double BaseNumber = Pc.nextDouble();
	 System.out.print("Enter the exponent: ");
	 double Exponent = Pc.nextDouble();
	 
	 double Output = Math.pow(BaseNumber, Exponent);
	 System.out.print("The required output = " + Output);
}
}