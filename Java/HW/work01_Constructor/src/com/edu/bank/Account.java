package com.edu.bank;

public class Account {
	public double balance; 
	
	public Account(double balance){
		this.balance=balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(int amt){
		balance += amt;
		System.out.println(amt + "원 저축");
	}
	
	public void withdraw(int amt){
		balance -= amt;
		System.out.println(amt + "원 출금");
	}
}
