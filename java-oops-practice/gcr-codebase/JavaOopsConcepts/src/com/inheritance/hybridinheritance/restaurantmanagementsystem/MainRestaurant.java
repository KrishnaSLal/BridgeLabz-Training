package com.inheritance.hybridinheritance.restaurantmanagementsystem;

public class MainRestaurant {

    public static void main(String[] args) {

        Worker w1 = new Chef("Rahul", 101);
        Worker w2 = new Waiter("Anita", 102);

        ((Person) w1).displayPersonDetails();
        w1.performDuties();
        System.out.println();

        ((Person) w2).displayPersonDetails();
        w2.performDuties();
    }
}
