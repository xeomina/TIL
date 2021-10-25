package com.edu.bank;

/*
 * ���忡 ���� ������ ������ �ִ� Ŭ����
 * balance, bankName �ʵ带 ����
 * 
 * �ڹٿ����� ��� Ŭ������ �ۼ��� �� �ݵ�� Encapsulation ����� ���� �ۼ�
 * 
 */


public class Account {
	//1.�ʵ� ����
	private double balance;
	private String bankName;
	
	//2.������θ� ����

	public Account(double balance, String bankName) {
		super();
		this.balance = balance;
		this.bankName = bankName;
	}
	
	//3. �ʵ带 ��ȯ
	public String getDetails() {
		return balance+","+bankName;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	//������ ���
	public void deposit(double amt) {
		if(amt>=1000) 	//1õ�� �̻��� �ݾ׸� �Ա� ����
		balance += amt;
		else 
			System.out.println("==1õ���̻��� �ݾ��� �Է��ϼ���==");
			return;	//ȣ���� �������� �ٽ� �ǵ��� - Ÿ���� ���� �ٽ� �Է��ϵ��� ����
	}

	public void withdraw(double amt) {
		if(balance>=amt) 	//�ܾ� �̻��� �ݾ׸� ��� ����
		balance -= amt;
		else 
			System.out.println("==�ܾ��̻��� �ݾ��� �Է��ϼ���==");
			return;
	}
	
	public double getBalance() {
		return balance;
	}


}
