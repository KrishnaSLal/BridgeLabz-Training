package com.hospitalmanagementsystem;

class Bill implements Payable {
    private double consultationFee;
    private double roomCharge;
    private double discount;

    public Bill(double consultationFee, double roomCharge, double discount) {
        this.consultationFee = consultationFee;
        this.roomCharge = roomCharge;
        this.discount = discount;
    }

    @Override
    public double calculatePayment() {
        double total = consultationFee + roomCharge;
        double discountedAmount = total - discount;
        double tax = discountedAmount * 0.05; // 5% tax
        return discountedAmount + tax;
    }
}
