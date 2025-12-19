import java.util.Scanner;
public class SmallestNumberCheck{
       public static void main(String[]args){
	   
	      int number1, number2, number3;
		  
		  Scanner input = new Scanner(System.in);
		  
		  System.out.print("Enter the first number: ");
		  number1 = input.nextInt();
		  
		  System.out.print("Enter the second number: ");
		  number2 = input.nextInt();
		  
		  System.out.print("Enter the third number: ");
		  number3 = input.nextInt();
		  
		     if(number1<number2 && number1<number3){
		         System.out.print("Yes,the first number is the smallest. ");
			}else{
			System.out.print("No, the first number is not the smallest.");
			}
		  
		    input.close();
	   }
}