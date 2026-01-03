package vehiclerentalapplication;

class Customer {
    private int customerId;
    private String name;

    public Customer(int id, String name) {
        this.customerId = id;
        this.name = name;
    }

    public void rentVehicle(Vehicle vehicle, int days) {
        vehicle.displayInfo();
        System.out.println("Rented by: " + name);
        System.out.println("Total Rent for " + days + " days: ₹" + vehicle.calculateRent(days));
    }
}
