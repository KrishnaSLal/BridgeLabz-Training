package com.ambulanceroute;

public class HospitalUnit {
    
	  private HospitalUnitNode head = null;

	    // Add unit to circular list
	    void addUnit(String name, boolean available) {
	        HospitalUnitNode newUnit = new HospitalUnitNode(name, available);

	        if (head == null) {
	            head = newUnit;
	            newUnit.next = head;
	            return;
	        }

	        HospitalUnitNode temp = head;
	        while (temp.next != head) {
	            temp = temp.next;
	        }
	        temp.next = newUnit;
	        newUnit.next = head;
	    }

	    // Find nearest available unit
	    void redirectPatient() {
	        if (head == null) {
	            System.out.println("No hospital units available!");
	            return;
	        }

	        HospitalUnitNode temp = head;
	        do {
	            if (temp.available) {
	                System.out.println("Patient redirected to: " + temp.name);
	                return;
	            }
	            temp = temp.next;
	        } while (temp != head);

	        System.out.println("No available unit found!");
	    }

	    // Remove unit under maintenance
	    void removeUnit(String unitName) {
	        if (head == null) return;

	        HospitalUnitNode curr = head;
	        HospitalUnitNode prev = null;

	        do {
	            if (curr.name.equalsIgnoreCase(unitName)) {
	                if (curr == head && curr.next == head) {
	                    head = null;
	                } else {
	                    if (curr == head) {
	                        HospitalUnitNode last = head;
	                        while (last.next != head) {
	                            last = last.next;
	                        }
	                        head = head.next;
	                        last.next = head;
	                    } else {
	                        prev.next = curr.next;
	                    }
	                }
	                System.out.println("Unit removed: " + unitName);
	                return;
	            }
	            prev = curr;
	            curr = curr.next;
	        } while (curr != head);

	        System.out.println("Unit not found!");
	    }

	    // Display route
	    void displayUnits() {
	        if (head == null) {
	            System.out.println("No units available.");
	            return;
	        }

	        HospitalUnitNode temp = head;
	        System.out.print("Hospital Route: ");
	        do {
	            System.out.print(temp.name + " - ");
	            temp = temp.next;
	        } while (temp != head);
	        System.out.println("(Back to Emergency)");
	    }
}