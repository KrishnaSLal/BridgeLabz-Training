package com.robowarehouse;

public class PackageItem {

    private int packageId;
    private double weight;

    public PackageItem(int packageId, double weight) {
        this.packageId = packageId;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "PackageID: " + packageId +", Weight: " + weight + " kg";
    }
}
