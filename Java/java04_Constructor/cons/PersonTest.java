package com.edu.cons;

class Person{
	String name;
	int age;
	
	Person(){} 
	
	Person(String name, int age){		
		this.name = name;
		this.age = age;
	}
	
	public void setPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getPerson() {
		return name +"," + age;
	}
}

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person("James", 65);
		Person p2 = new Person("Kate", 30);
		Person p3 = new Person();
		
		p3.setPerson("John", 40);		
		
		System.out.println(p1.getPerson());
		System.out.println(p2.getPerson());
		System.out.println(p3.getPerson());

	}

}
