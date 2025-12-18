import java.util.Scanner;
public class AreaOfCircle{
       public static void main(String[]args){
        
		Scanner AC = new Scanner(System.in);
	    System.out.print("Enter the radius of the circle: ");
		float radius = AC.nextFloat();
		
        System.out.print("The required area = " + (3.14*radius*radius));
		AC.close();
}
}
