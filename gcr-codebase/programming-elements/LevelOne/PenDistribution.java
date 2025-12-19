public class PenDistribution{
       public static void main(String[]args){
	   
	   int NumberOfStudents = 3, NumberOfPens = 14;
	   int PenPerStudent = NumberOfPens/NumberOfStudents;
	   int RemainingPens = NumberOfPens%NumberOfStudents;
	   
	   System.out.println("The Pen Per Student is " + PenPerStudent + " and the remaining pen not distributed is " + RemainingPens + ".");
	   }
}