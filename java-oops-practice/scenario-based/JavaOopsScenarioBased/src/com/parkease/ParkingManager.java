package com.parkease;

import java.util.*;

class ParkingManager {

    private Map<Integer, String> bookingRecords = new HashMap<>();

    public void parkVehicle(ParkingSlot slot, Vehicle vehicle) {

        if (!slot.isAvailable()) {
            System.out.println("Slot already occupied.");
            return;
        }

        slot.assignSlot();
        bookingRecords.put(slot.getSlotId(), vehicle.vehicleNumber);

        System.out.println("Vehicle parked successfully in slot " + slot.getSlotId());
    }

    public void releaseVehicle(ParkingSlot slot, Vehicle vehicle, int hours) {

        slot.releaseSlot();
        bookingRecords.remove(slot.getSlotId());

        double charges = vehicle.calculateCharges(hours);
        System.out.println("Vehicle released. Charges: ₹" + charges);
    }

    public void showLogs() {
        System.out.println("Current Booking Records:");
        bookingRecords.forEach((k, v) ->
                System.out.println("Slot " + k + " → Vehicle " + v));
    }
}
