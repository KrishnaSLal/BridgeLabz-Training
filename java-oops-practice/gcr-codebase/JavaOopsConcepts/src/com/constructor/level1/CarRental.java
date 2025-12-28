package com.constructor.level1;

public class CarRental {

	private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    // Constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = setDailyRate(carModel); // assign rate based on car model
    }

    // Method to set daily rate depending on car model
    private double setDailyRate(String carModel) {
        switch (carModel.toLowerCase()) {
            case "sedan":
                return 2000; // INR per day
            case "suv":
                return 3500;
            case "hatchback":
                return 1500;
            default:
                return 2500; // default rate
        }
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    // Method to display rental details
    public void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: ₹" + dailyRate);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
        System.out.println("-----------------------------");
    }

    // Main method inside CarRental class
    public static void main(String[] args) {
        // Hardcoded examples
        CarRental rental1 = new CarRental("Krishna", "SUV", 3);
        CarRental rental2 = new CarRental("Anita", "Sedan", 5);
        CarRental rental3 = new CarRental("Ravi", "Hatchback", 2);

        System.out.println("--- Rental Details ---");
        rental1.displayDetails();
        rental2.displayDetails();
        rental3.displayDetails();
    }
}

