package com.edu.bank.service;

import com.edu.bank.vo.Customer;
import com.edu.bank.vo.Product;

/*
 * �ƿ﷿���� ��ǰ�� �����ϴ� ������ ���� ����� �ٷ�� Service Ŭ����
 * ��ɵ鸸 ���ǵǾ��� �ִ�..
 */
public class CustomerService {
	//1. Ư�� ������ ������ ��ǰ�� �����ϴ� ���
	public Product[ ] getProduct(Customer c) {
		System.out.println("==1. Ư�� ������ ������ ��ǰ==");
		return c.getProducts();
	}
	
	//2. Ư�� ������ ������ ��ǰ�� maker�鸸 �����ϴ� ���
	public String[ ] getAllProductMaker(Customer c) {
		System.out.println("==2. Ư�� ������ ������ ��ǰ�� maker==");
		String[ ] temp = new String[c.getProducts().length];
		Product[ ] pros=c.getProducts();
		int cnt = 0;
		for(Product p : pros) temp[cnt++] = p.getMaker();		
		return temp;
	}
	//3. Outlet�ȿ� �ִ� ��� ������ �����ϴ� ���
	public Customer[ ] getAllCustomer(Customer[ ] custs) {
		System.out.println("==3. Outlet�ȿ� �ִ� ��� ����==");
		Customer[ ] temp = new Customer[custs.length];
		int cnt = 0;
		for(Customer c : custs) temp[cnt++] = c;		
		return temp;
	}
	//4. ��� ������ �߿��� Ư���� ������ �˻��ϴ� ���...ssn���� �˻�
//	public Customer getCustomer(Customer[ ] custs, int ssn) {
//	public Customer findCustomer(Customer[ ] custs, int ssn) {
	public Customer findCustomerBySsn(Customer[ ] custs, int ssn) {
		System.out.println("==4. ��� ������ �߿��� Ư���� ����==");
		Customer customer=  null;
		for(Customer c : custs) {
			if(c.getSsn()==ssn) customer = c;
		}
		return customer;
	}	
	//5. Ư�� ������ ������ ������ �ְ����� �ش��ϴ� ������ ������ �����ϴ� ���
	public int maxPriceProduct(Customer c) {
		System.out.println("==5. �ְ����� �ش��ϴ� ������ ����==");
		int maxPice = 0;
		Product[ ] pros = c.getProducts();
		for(Product p : pros) {
			if(p.getPrice()>maxPice) maxPice = p.getPrice();
		}
		return maxPice;
	}
	//6. ��� ������ ������ ������ Ư������ �̻�Ǵ� ��ǰ���� �����ϴ� ���
	public Product[ ] getMorePriceProducts(Customer[ ] custs, int price) {
		System.out.println("==6. Ư������ �̻�Ǵ� ��ǰ==");
		int len = 0;
		int cnt = 0;
		for(Customer c : custs) len+= c.getProducts().length;
				
		Product[ ] temp = new Product[len];
		
		for(Customer c : custs) {
			for(Product p : c.getProducts()) {
				if(p.getPrice()>price) temp[cnt++] = p;
			}
		}		
		return temp;	
	}
	//7. ������ ���׿� ����ִ� �������� �����ϴ� ���
//	public Customer[ ] findSameAddressCustomer(Customer[ ] custs, String address) {
//	public Customer[ ] findCustomer(Customer[ ] custs, String address) {
	public Customer[ ] findCustomerByAddr(Customer[ ] custs, String address) {
		System.out.println("==7. ������ ���׿� ����ִ� ����==");
		Customer[ ] temp = new Customer[custs.length];
		int cnt = 0;
		for(Customer c : custs) {
			if(c.getAddress().equals(address)) temp[cnt++] = c;
		}
		return temp;
	}
}
