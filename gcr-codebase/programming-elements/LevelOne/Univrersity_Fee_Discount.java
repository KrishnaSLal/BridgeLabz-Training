import java.util.Scanner;
public class Univrersity_Fee_Discount{
       public static void main(String[]args){
	   
	     Scanner input = new Scanner(System.in);
		 
		 System.out.print("Enter the university fee: ");
		 double fee = input.nextDouble();
		 
		 System.out.print("Enter the discount percent: ");
		 double discountPercent = input.nextDouble();
		 
		 //Calculations for discount and final fee
		 double discount = (fee*discountPercent)/100;
		 double payableFee = fee - discount;
		 
		 System.out.print("The discount amount is INR " + discount + " and final discounted fee is INR " + payableFee +  ".");
		 
		 input.close();
		 
	   }
}