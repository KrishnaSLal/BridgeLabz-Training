import java.util.Scanner;
public class  DoubleOpt{
       public static void main(String[]args){
	      
		  double a, b, c;
		  
	      Scanner input = new Scanner(System.in);
		  
		  System.out.print("Enter the double value for a : ");
		  a = input.nextDouble();
		  System.out.print("Enter the double value for b : ");
		  b = input.nextDouble();
		  System.out.print("Enter the double value for c : ");
		  c = input.nextDouble();
		  
		  //Computation of the given operations
		  double result1 = a + b *c;
		  double result2 = a * b + c;
		  double result3 = c + a / b;
		  double result4 = a % b + c;
		  
		  System.out.print("Result 1 = "+ result1 + "," + " Result 2 = " + result2+ "," +  " Result 3 = "+ result3 + ","+ " Result 4 = "+ result4 );
		  
		  input.close();
		  
		  
	   }
}