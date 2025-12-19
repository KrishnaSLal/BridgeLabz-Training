import java.util.Scanner;
public class  IntOperation{
       public static void main(String[]args){
	      
		  int a, b, c;
		  
	      Scanner input = new Scanner(System.in);
		  
		  System.out.print("Enter the integer value for a : ");
		  a = input.nextInt();
		  System.out.print("Enter the integer value for b : ");
		  b = input.nextInt();
		  System.out.print("Enter the integer value for c : ");
		  c = input.nextInt();
		  
		  //Computation of the given operations
		  int result1 = a + b *c;
		  int result2 = a * b + c;
		  int result3 = c + a / b;
		  int result4 = a % b + c;
		  
		  System.out.print("Result 1 = "+ result1 + "," + " Result 2 = " + result2+ "," +  " Result 3 = "+ result3 + ","+ " Result 4 = "+ result4 );
		  
		  input.close();
		  
		  
	   }
}