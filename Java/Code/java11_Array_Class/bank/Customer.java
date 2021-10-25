package com.edu.bank;

/* 
 * ���� ���� ������ ��� �ִ� Ŭ����
 * �ش� ���� �������� ������ ������ �ִ� ������ ����Ǿ��� �ִ�
 * 
 * Customer Ŭ������
 * Account[] Ŭ������ ������ �����̴�
 */

public class Customer {
	//1.�ʵ� ����
	//������ ����
	private int ssn;	//�ֹι�ȣ
	private String name;
	
	//Has a Relation
	//setter ����
	private Account[] accounts;
	
	//2.������ �ʵ尪�� ���� �����Ѵ�
	public Customer(int ssn, String name) {
		super();
		this.ssn = ssn;
		this.name = name;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	
	//���� ������ ��ȯ
	public String getCustomerInfo() {
		return ssn+","+name;
	}
	
	


	

}
