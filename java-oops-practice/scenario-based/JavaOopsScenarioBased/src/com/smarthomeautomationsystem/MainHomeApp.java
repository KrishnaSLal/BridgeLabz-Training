package com.smarthomeautomationsystem;

public class MainHomeApp {
	public static void main(String[] args) {

        UserController controller = new UserController();

        Appliance light = new Light();
        Appliance fan = new Fan();
        Appliance ac = new AC();

        controller.controlDevice(light, true);
        controller.controlDevice(ac, true);

        controller.compareEnergy(light, ac);

        controller.controlDevice(light, false);
        controller.controlDevice(ac, false);
    }
}
