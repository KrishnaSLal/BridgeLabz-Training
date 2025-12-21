import java.util.Scanner;

public class UnitConvertor{

    //To convert kilometer to mile
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    //to convert mile to kilometer
    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }
    
	//To convert meter to feet
    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    //To convert feet to meter
    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
		//Take the required conversion from the user
        System.out.print("Enter conversion type (km-miles, miles-km, meters-feet, feet-meters): ");
        String type = input.next();
        
		//Take the value input 
        System.out.print("Enter value: ");
        double value = input.nextDouble();

        double result = 0;
        
		//Check the condition required
        if (type.equalsIgnoreCase("km-miles")) {
            result = convertKmToMiles(value);
            System.out.printf("%.2f km = %.2f miles%n", value, result);
        } else if (type.equalsIgnoreCase("miles-km")) {
            result = convertMilesToKm(value);
            System.out.printf("%.2f miles = %.2f km%n", value, result);
        } else if (type.equalsIgnoreCase("meters-feet")) {
            result = convertMetersToFeet(value);
            System.out.printf("%.2f meters = %.2f feet%n", value, result);
        } else if (type.equalsIgnoreCase("feet-meters")) {
            result = convertFeetToMeters(value);
            System.out.printf("%.2f feet = %.2f meters%n", value, result);
        } else {
            System.out.println("Invalid conversion type!");
        }

        input.close();
    }
}