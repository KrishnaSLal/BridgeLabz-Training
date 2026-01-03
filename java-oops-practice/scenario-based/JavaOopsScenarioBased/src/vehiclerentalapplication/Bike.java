package vehiclerentalapplication;

class Bike extends Vehicle {

    public Bike(int id, String brand) {
        super(id, brand, 300);
    }

    @Override
    public double calculateRent(int days) {
        return baseRate * days;   // Simple calculation
    }
}
