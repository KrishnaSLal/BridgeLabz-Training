public class ProfitAndLoss{
       public static void main(String[]args){
	   
	     int CostPrice = 129 , SellingPrice = 191;
		 
		 //Profit = selling price - cost price
         double Profit = SellingPrice - CostPrice;
		 
		 //Profit Percentage = profit / cost price * 100
         double ProfitPercentage = (Profit/CostPrice)*100;
		 
		 System.out.println("The Cost Price is INR " + CostPrice + " and Selling Price is INR "+ SellingPrice);
		 System.out.println("The Profit is INR "+ Profit + "and the Profit Percentage is "+ ProfitPercentage);
		 
	   }
}