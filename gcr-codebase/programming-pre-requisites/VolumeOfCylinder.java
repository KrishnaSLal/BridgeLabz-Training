import java.util.Scanner;
public class VolumeOfCylinder{
public static void main(String[]args){
     
     Scanner Cy = new Scanner(System.in);
     System.out.print("Enter the radius of the cylinder: ");
	 double radius = Cy.nextDouble(); 
	 System.out.print("Enter the height of the cylinder: ");
	 double height = Cy.nextDouble();
	 // Volume of a cylinder = Pi * radius^2 * height
	 double volume = Math.PI * radius * radius *height;
	 
	 System.out.print("The volume of the cylinder = " + volume);
	 
}
}