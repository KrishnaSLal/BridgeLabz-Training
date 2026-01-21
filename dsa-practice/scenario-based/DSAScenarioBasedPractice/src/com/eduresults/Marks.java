package com.eduresults;

public class Marks {

	private String district;
	private String name;
	private int rollno;
	private float marks;
	
	public Marks(String district, String name,int rollno, float marks) {
		this.district = district;
		this.name = name;
		this.rollno = rollno;
		this.marks = marks;
	}
	public float getMarks() {
		return marks;
	}
	 @Override
	public String toString() {
		return "Roll number: " + rollno + ", Name: "+ name + ", Marks: " + marks +", District: " + district ;
	}
}

