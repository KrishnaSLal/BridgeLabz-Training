package smarthomeautomationsystem;

class Fan extends Appliance {

    public Fan() {
        super(75);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println("Fan spinning ON (" + getPowerConsumption() + "W)");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("Fan stopped");
    }
}
