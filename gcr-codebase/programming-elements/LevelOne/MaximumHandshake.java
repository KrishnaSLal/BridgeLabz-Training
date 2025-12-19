import java.util.Scanner;
public class MaximumHandshake{
       public static void main(String[]args){
	   
	   Scanner input = new Scanner(System.in);
	   
	   System.out.print("Enter the number of students: ");
	   int numberOfStudents = input.nextInt();
	   
	   
	   
	   //Calculation formula: (n * (n - 1)) / 2 
	   int Maximum = (numberOfStudents * (numberOfStudents - 1)) / 2;
	   
	   System.out.print("Maximum possible handshake = " + Maximum);
	   
	   input.close();
	   
	   }
}