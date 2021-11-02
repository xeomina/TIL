package com.edu.bank.vo;

/*
 * Outlet에서 상품을 구입하는 고객에 대한 정보를 담고 있는 VO 클래스
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

/*	public void setSsn(int ssn) {			//주민번호는 수정 x - 메소드 제거
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

	public void changeAddress(String address) {		//나중에 주소 변경 - change로 변경
		this.address = address;
	}

	public Product[] getProducts() {
		return products;
	}

	public void buyProducts(Product[] products) {	//상품을 구매 - buy로 변경
		this.products = products;
	}
	
	public String getCustomerInfo() {
		return name+", "+address;
	}


	
	

}
