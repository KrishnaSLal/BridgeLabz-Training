package com.reflection.customloggingproxy;

import java.lang.reflect.Proxy;
import java.util.Scanner;

public class MainDynamicProxy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Greeting realGreeting = new GreetingImpl();

            // Create dynamic proxy
            Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                    Greeting.class.getClassLoader(),
                    new Class[]{Greeting.class},
                    new LoggingHandler(realGreeting)
            );

            // User chooses method
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Choose method (1: sayHello, 2: sayGoodbye): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    proxyGreeting.sayHello(name);
                    break;
                case 2:
                    proxyGreeting.sayGoodbye(name);
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
