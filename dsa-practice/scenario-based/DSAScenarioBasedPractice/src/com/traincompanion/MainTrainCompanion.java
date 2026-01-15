package com.traincompanion;

public class MainTrainCompanion {
    public static void main(String[] args) {

        Train train = new Train();

        train.addCompartment("C1", "General");
        train.addCompartment("C2", "WiFi");
        train.addCompartment("C3", "Pantry");
        train.addCompartment("C4", "Sleeper");

        train.traverseForward();
        System.out.println();

        train.traverseBackward();
        System.out.println();

        train.showAdjacent("C3");
        System.out.println();

        train.removeCompartment("C2");
        System.out.println();

        train.traverseForward();
    }
}
