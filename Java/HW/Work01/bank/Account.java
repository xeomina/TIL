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
		System.out.println(amt + "�� ����");
	}
	
	public void withdraw(int amt){
		balance -= amt;
		System.out.println(amt + "�� ���");
	}
}
