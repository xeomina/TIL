package com.edu.bank.service;

import com.edu.bank.vo.Customer;
import com.edu.bank.vo.Product;

/*
 * 아울렛에서 상품을 구매하는 고객에 대한 기능을 다루는 Service 클래스
 * 기능들만 정의되어져 있다..
 */
public class CustomerService {
	//1. 특정 고객이 구입한 상품을 리턴하는 기능
	public Product[ ] getProduct(Customer c) {
		System.out.println("==1. 특정 고객이 구입한 상품==");
		return c.getProducts();
	}
	
	//2. 특정 고객이 구입한 상품의 maker들만 리턴하는 기능
	public String[ ] getAllProductMaker(Customer c) {
		System.out.println("==2. 특정 고객이 구입한 상품의 maker==");
		String[ ] temp = new String[c.getProducts().length];
		Product[ ] pros=c.getProducts();
		int cnt = 0;
		for(Product p : pros) temp[cnt++] = p.getMaker();		
		return temp;
	}
	//3. Outlet안에 있는 모든 고객을 리턴하는 기능
	public Customer[ ] getAllCustomer(Customer[ ] custs) {
		System.out.println("==3. Outlet안에 있는 모든 고객==");
		Customer[ ] temp = new Customer[custs.length];
		int cnt = 0;
		for(Customer c : custs) temp[cnt++] = c;		
		return temp;
	}
	//4. 모든 고객들 중에서 특정한 고객을 검색하는 기능...ssn으로 검색
//	public Customer getCustomer(Customer[ ] custs, int ssn) {
//	public Customer findCustomer(Customer[ ] custs, int ssn) {
	public Customer findCustomerBySsn(Customer[ ] custs, int ssn) {
		System.out.println("==4. 모든 고객들 중에서 특정한 고객==");
		Customer customer=  null;
		for(Customer c : custs) {
			if(c.getSsn()==ssn) customer = c;
		}
		return customer;
	}	
	//5. 특정 고객이 구입한 물건중 최고가에 해당하는 물건의 가격을 리턴하는 기능
	public int maxPriceProduct(Customer c) {
		System.out.println("==5. 최고가에 해당하는 물건의 가격==");
		int maxPice = 0;
		Product[ ] pros = c.getProducts();
		for(Product p : pros) {
			if(p.getPrice()>maxPice) maxPice = p.getPrice();
		}
		return maxPice;
	}
	//6. 모든 고객이 구입한 물건중 특정가격 이상되는 제품들을 리턴하는 기능
	public Product[ ] getMorePriceProducts(Customer[ ] custs, int price) {
		System.out.println("==6. 특정가격 이상되는 제품==");
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
	//7. 동일한 동네에 살고있는 고객들을 리턴하는 기능
//	public Customer[ ] findSameAddressCustomer(Customer[ ] custs, String address) {
//	public Customer[ ] findCustomer(Customer[ ] custs, String address) {
	public Customer[ ] findCustomerByAddr(Customer[ ] custs, String address) {
		System.out.println("==7. 동일한 동네에 살고있는 고객==");
		Customer[ ] temp = new Customer[custs.length];
		int cnt = 0;
		for(Customer c : custs) {
			if(c.getAddress().equals(address)) temp[cnt++] = c;
		}
		return temp;
	}
}

