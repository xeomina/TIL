package com.edu.bank;

/*
 * 통장에 대한 정보를 가지고 있는 클래스
 * balance, bankName 필드를 선언
 * 
 * 자바에서는 모든 클래스를 작성할 때 반드시 Encapsulation 기법을 따라서 작성
 * 
 */


public class Account {
	//1.필드 선언
	private double balance;
	private String bankName;
	
	//2.주입통로를 결정

	public Account(double balance, String bankName) {
		super();
		this.balance = balance;
		this.bankName = bankName;
	}
	
	//3. 필드를 반환
	public String getDetails() {
		return balance+","+bankName;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	//나머지 기능
	public void deposit(double amt) {
		if(amt>=1000) 	//1천원 이상의 금액만 입금 가능
		balance += amt;
		else 
			System.out.println("==1천원이상의 금액을 입력하세요==");
			return;	//호출한 지점으로 다시 되돌림 - 타당한 값을 다시 입력하도록 제어
	}

	public void withdraw(double amt) {
		if(balance>=amt) 	//잔액 이상의 금액만 출금 가능
		balance -= amt;
		else 
			System.out.println("==잔액이상의 금액을 입력하세요==");
			return;
	}
	
	public double getBalance() {
		return balance;
	}


}
