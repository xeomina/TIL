package com.edu.parent;

public class Person {
	private String name;
	private int age;
	private String address;
	
	public Person() {}		//디폴트 생성자
	public Person(String name, int age, String address) {		//명시적 생성자
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}


	public String getDetails() {
		return name+","+age+","+address;
	}
	
	@Override
	public String toString() {
		return name+","+age+","+address;
	}
	
	

}
