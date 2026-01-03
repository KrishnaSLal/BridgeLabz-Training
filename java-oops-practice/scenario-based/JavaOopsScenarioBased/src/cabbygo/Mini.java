package cabbygo;

class Mini extends Vehicle {
    public Mini(String vehicleNumber) {
        super(vehicleNumber, 4, "Mini");
    }

    @Override
    public double calculateFare(double distance) {
        double fare = 50 + distance * 10;
        setFare(fare);
        return fare;
    }
}

class Sedan extends Vehicle {
    public Sedan(String vehicleNumber) {
        super(vehicleNumber, 4, "Sedan");
    }

    @Override
    public double calculateFare(double distance) {
        double fare = 70 + distance * 15;
        setFare(fare);
        return fare;
    }
}

class SUV extends Vehicle {
    public SUV(String vehicleNumber) {
        super(vehicleNumber, 6, "SUV");
    }

    @Override
    public double calculateFare(double distance) {
        double fare = 100 + distance * 20;
        setFare(fare);
        return fare;
    }
}
