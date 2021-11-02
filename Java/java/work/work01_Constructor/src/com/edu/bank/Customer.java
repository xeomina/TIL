package com.edu.bank;

public class Customer {
	String firstName;
	String lastName;
	Account account;
	
	public Customer(){}
	public Customer(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;	
	}
	
	public void setAccount(Account acc) {
		this.account = acc;
	}
	
	public Account getAccount() {
		return account;		
	}
	
	public String getCustomer() {
		return firstName + " " + lastName;		
	}

}
