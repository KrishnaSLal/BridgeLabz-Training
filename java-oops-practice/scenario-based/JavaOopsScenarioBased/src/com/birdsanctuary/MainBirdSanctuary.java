package com.birdsanctuary;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MainBirdSanctuary {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        BirdSanctuary sanctuary = new BirdSanctuary();
        int choice;

        System.out.println("Welcome to EcoWing Bird Sanctuary");

        do {
            System.out.println("\n1. Add Bird");
            System.out.println("2. Display All Birds");
            System.out.println("3. Delete Bird by ID");
            System.out.println("4. Sanctuary Report");
            System.out.println("5. Show Annotation Info");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter bird type (Eagle/Duck/Penguin/Kiwi): ");
                    String type = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    Bird bird = null;
                    if (type.equalsIgnoreCase("Eagle")) bird = new Eagle(name, id);
                    else if (type.equalsIgnoreCase("Duck")) bird = new Duck(name, id);
                    else if (type.equalsIgnoreCase("Penguin")) bird = new Penguin(name, id);
                    else if (type.equalsIgnoreCase("Kiwi")) bird = new Kiwi(name, id);

                    if (bird != null) sanctuary.addBird(bird);
                    break;

                case 2:
                    sanctuary.displayAll();
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    sanctuary.removeById(sc.nextLine());
                    break;

                case 4:
                    sanctuary.report();
                    break;

                case 5:
                    Class<Bird> cls = Bird.class;
                    if (cls.isAnnotationPresent(DeveloperInfo.class)) {
                        DeveloperInfo info = cls.getAnnotation(DeveloperInfo.class);
                        System.out.println("Developer: " + info.developer());
                        System.out.println("Version: " + info.version());
                    }
                    break;
            }

        } while (choice != 6);

        sc.close();
    }
}
