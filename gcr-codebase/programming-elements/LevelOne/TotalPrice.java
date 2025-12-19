import java.util.Scanner;
public class TotalPrice{
       public static void main(String[]args){
	   
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the unit price of the item: ");
		float unitPrice = input.nextFloat();
		
		System.out.print("Enter the number of item to be bought: ");
		int quantity = input.nextInt();
		
		//Calculations 
		float totalPrice = quantity*Unitprice;
		
		System.out.print("The total purchase price is INR"+  Totalprice + "if the quantity " + quantity + "and unit price is " + Unitprice);
        
		input.close();
	   }
}