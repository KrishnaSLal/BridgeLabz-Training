package com.ambulanceroute;

public class HospitalUnitNode {
	 String name;
	 boolean available;
	 HospitalUnitNode next;

	 public HospitalUnitNode(String name, boolean available) {
	 this.name = name;
	 this.available = available;
	 this.next = null;
	 }
}