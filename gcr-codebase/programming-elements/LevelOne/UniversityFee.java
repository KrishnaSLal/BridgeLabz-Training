public class UniversityFee{
       public static void main(String[]args){
	   
	      int fee = 125000 , discountPercent = 10;
		  float discountAmount = (fee*discountPercent)/100;
		  float FinalFee = fee - discountAmount;
		  
		  System.out.println(" The discount amount is INR " + discountAmount + " and final discounted fee is INR "+ FinalFee + ".");
	   }
}