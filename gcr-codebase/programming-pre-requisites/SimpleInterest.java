import java.util.Scanner;
public class SimpleInterest{
public static void main(String[]args){
    
	  Scanner SI = new Scanner(System.in);
	  System.out.print("Enter the Principal Amount: ");
	  double Principal = SI.nextDouble();
	  System.out.print("Enter the Rate (in per cent): ");
	  double Rate = SI.nextDouble();
	  System.out.print("Enter the time(in years): ");
	  double Time = SI.nextDouble();
	  
	  //Simple Interest = (Principal * Rate * Time) / 100.
	  double SimpleInterest = (Principal * Rate * Time) / 100;
	  System.out.print("The Simple Interest is: " + SimpleInterest);
	  
}
}