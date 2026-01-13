package com.homenest;

import java.util.Scanner;

public class MainHomeNest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter user name: ");
        User user = new User(sc.nextLine());

        while (true) {
            System.out.println("\n1. Add Device");
            System.out.println("2. Turn ON Device");
            System.out.println("3. Turn OFF Device");
            System.out.println("4. Reset Device");
            System.out.println("5. Show Devices");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Select Device Type:");
                    System.out.println("1. Light  2. Camera  3. Thermostat  4. Lock");
                    int type = sc.nextInt();
                    System.out.print("Enter Device ID: ");
                    String id = sc.next();

                    Device device = null;
                    if (type == 1) device = new Light(id);
                    else if (type == 2) device = new Camera(id);
                    else if (type == 3) device = new Thermostat(id);
                    else if (type == 4) device = new Lock(id);

                    user.registerDevice(device);
                    break;

                case 2:
                    user.showDevices();
                    System.out.print("Select device index: ");
                    user.getDevice(sc.nextInt()).turnOn();
                    break;

                case 3:
                    user.showDevices();
                    System.out.print("Select device index: ");
                    user.getDevice(sc.nextInt()).turnOff();
                    break;

                case 4:
                    user.showDevices();
                    System.out.print("Select device index: ");
                    user.getDevice(sc.nextInt()).reset();
                    break;

                case 5:
                    user.showDevices();
                    break;

                case 6:
                    System.out.println("Exiting HomeNest");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
