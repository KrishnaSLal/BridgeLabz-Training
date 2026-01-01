package com.inheritance.hybridinheritance.restaurantmanagementsystem;

interface Worker {
    void performDuties();
}
class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Chef is preparing delicious meals 👨‍🍳");
    }
}
