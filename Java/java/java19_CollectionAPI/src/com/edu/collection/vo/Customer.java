package com.edu.collection.vo;

public class Customer {
	private String custId;
	private String name;
	private int age;
	
	public Customer() {	}
	public Customer(String custId, String name, int age) {
		super();
		this.custId = custId;
		this.name = name;
		this.age = age;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", age=" + age + "]";
	}
	
	

}
