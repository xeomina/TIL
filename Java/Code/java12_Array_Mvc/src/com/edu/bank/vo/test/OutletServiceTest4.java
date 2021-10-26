package com.edu.bank.vo.test;

import com.edu.bank.service.CustomerService;

import com.edu.bank.vo.Product;
import com.edu.bank.vo.Customer;

public class OutletServiceTest4 {

	public static void main(String[] args) {
		Product[] pros1 = {
	            new Product("�Ŷ��", 3000, 4, "���"),
	            new Product("����", 12000, 10, "���"),
	            new Product("����ũ��", 23000, 1, "LG"),
	            new Product("������", 440000, 1, "���")
		};
		
		
	    Product[ ] pros2= {
	            new Product("�׿�ġ��", 8000, 3, "LG"),
	            new Product("�����", 1000, 2, "���"),
	            new Product("����Ÿ��", 50000, 1, "LG")
	    };
	    
	    Product[ ] pros3= {
	            new Product("�����", 2000, 3, "���"),
	            new Product("����", 10000, 2, "LG"),
	            new Product("��Ʈ��", 900000, 1, "�Ｚ")
	    };
	    
	    Customer[ ] cust= {
	            new Customer(111, "����", "��赿" ),
	            new Customer(222, "������", "�Ż絿"),
	            new Customer(333, "����", "�Ż絿"),
	    };
	    
	    //������ ���� ��ǰ ����
	    cust[0].buyProducts(pros1);
	    cust[1].buyProducts(pros2);
	    cust[2].buyProducts(pros3);
	        
	    CustomerService service = new CustomerService();
	    
	    //1. Ư�� ���� ������ ��ǰ�� �����ϴ� ���
//	    System.out.println(service.getProduct(cust[0]));
		Product[] returnPros = service.getProduct(cust[0]);
		for(Product p:returnPros)							
			System.out.println(p.getDetails());
		
	    
	    //2. Ư�� ���� ������ ��ǰ�� maker�鸸 �����ϴ� ���
//	    System.out.println(service.getAllProductMaker(cust[2]));
		String[] returnMakers = service.getAllProductMaker(cust[0]);
		for(String m:returnMakers)							
			System.out.println(m);
	    
	    //3. Outlet�ȿ� �ִ� ��� ���� �����ϴ� ���
//	    System.out.println(service.getAllCustomer(cust));
	    Customer[] returnCustomers = service.getAllCustomer(cust);
		for(Customer r:returnCustomers)							
			System.out.println(r.getName());
	    
	    //4. ��� ���� �߿��� Ư���� ���� �˻��ϴ� ���...ssn���� �˻�
//	    System.out.println(service.findCustomerBySsn(cust, 333));
	    Customer findCustomer = service.findCustomerBySsn(cust, 333);
		System.out.println(findCustomer.getName());
	    
	    //5. Ư�� ���� ������ ������ �ְ��� �ش��ϴ� ������ ������ �����ϴ� ���
	    System.out.println(service.maxPriceProduct(cust[0]));	
//	    int max = service.maxPriceProduct(cust[0]);
//		System.out.println(max);
	    
	    
	    //6. ��� ���� ������ ������ Ư������ �̻�Ǵ� ��ǰ���� �����ϴ� ���
//	    System.out.println(service.getMorePriceProducts(cust, 50000));
	    Product[ ] morepros = service.getMorePriceProducts(cust, 50000);
	    for(Product p : morepros) {
	    	if(p == null) continue;
	    	System.out.println(p.getDetails());
	    	}
	    		
	   
	    //7. ������ ���׿� ����ִ� ������ �����ϴ� ���
//	    System.out.println(service.findCustomerByAddr(cust, "�Ż絿"));
	    Customer[] findCustomers = service.findCustomerByAddr(cust, "�Ż絿");
		for(Customer f:findCustomers) {
	    	if(f == null) continue;						
			System.out.println(f.getName());
		}
	    

	   }// main

	}//class