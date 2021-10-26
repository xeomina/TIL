package com.edu.child;

import com.edu.parent.Person;

public class Teacher extends Person{
	private String subject;
	
	public Teacher(String name, int age, String address, String subject) {
		super(name, age, address);
		this.subject = subject;
	}

	@Override
	public String getDetails() {
		return super.getDetails()+","+subject;
	}
	
	@Override
	public String toString() {
		return super.toString()+","+subject;
	}

}
