package com.functionalinterface.consumer.loginactivity;

import java.util.function.Consumer;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalTime;

class Employee {

    int id;
    LocalTime inTime;
    LocalTime outTime;

    Employee(int id, LocalTime inTime, LocalTime outTime) {
        this.id = id;
        this.inTime = inTime;
        this.outTime = outTime;
    }
}

public class MainEmployeeLoginActivity {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the employee id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the in-time (HH:mm): ");
        LocalTime inTime = LocalTime.parse(sc.nextLine());

        System.out.print("Enter the out-time (HH:mm): ");
        LocalTime outTime = LocalTime.parse(sc.nextLine());

        Employee employee = new Employee(id, inTime, outTime);

        Duration duration = Duration.between(employee.inTime, employee.outTime);

        Consumer<Employee> loginActivity = e -> {
            System.out.println("\nEmployee Login Activity");
            System.out.println("Employee ID : " + e.id);
            System.out.println("In-Time     : " + e.inTime);
            System.out.println("Out-Time    : " + e.outTime);
        };

        loginActivity.accept(employee);

        System.out.println("\nTotal Working Hours: " + duration.toHours() + " hours " + duration.toMinutesPart() + " minutes" );

        sc.close();
    }
}
