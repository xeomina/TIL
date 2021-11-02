package com.edu.bank.vo;

/*
 * Outlet���� ��ǰ�� �����ϴ� ���� ���� ������ ��� �ִ� VO Ŭ����
 */
public class Customer {
	private int ssn;
	private String name;
	private String address;
	
	//Has a Relation
	private Product[] products;

	public Customer(int ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	public int getSsn() {
		return ssn;
	}

/*	public void setSsn(int ssn) {			//�ֹι�ȣ�� ���� x - �޼ҵ� ����
		this.ssn = ssn;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void changeAddress(String address) {		//���߿� �ּ� ���� - change�� ����
		this.address = address;
	}

	public Product[] getProducts() {
		return products;
	}

	public void buyProducts(Product[] products) {	//��ǰ�� ���� - buy�� ����
		this.products = products;
	}
	
	public String getCustomerInfo() {
		return name+", "+address;
	}


	
	

}
