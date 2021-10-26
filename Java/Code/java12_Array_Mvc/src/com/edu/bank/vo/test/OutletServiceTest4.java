package com.edu.bank.vo.test;

import com.edu.bank.service.CustomerService;

import com.edu.bank.vo.Product;
import com.edu.bank.vo.Customer;

public class OutletServiceTest4 {

	public static void main(String[] args) {
		Product[] pros1 = {
	            new Product("신라면", 3000, 4, "농심"),
	            new Product("생수", 12000, 10, "농심"),
	            new Product("옥시크린", 23000, 1, "LG"),
	            new Product("정수기", 440000, 1, "대우")
		};
		
		
	    Product[ ] pros2= {
	            new Product("죽염치약", 8000, 3, "LG"),
	            new Product("새우깡", 1000, 2, "농심"),
	            new Product("하이타이", 50000, 1, "LG")
	    };
	    
	    Product[ ] pros3= {
	            new Product("삼양라면", 2000, 3, "삼양"),
	            new Product("퐁퐁", 10000, 2, "LG"),
	            new Product("노트북", 900000, 1, "삼성")
	    };
	    
	    Customer[ ] cust= {
	            new Customer(111, "원빈", "방배동" ),
	            new Customer(222, "아이유", "신사동"),
	            new Customer(333, "현빈", "신사동"),
	    };
	    
	    //각각의 고객이 상품 구매
	    cust[0].buyProducts(pros1);
	    cust[1].buyProducts(pros2);
	    cust[2].buyProducts(pros3);
	        
	    CustomerService service = new CustomerService();
	    
	    //1. 특정 고객이 구입한 상품을 리턴하는 기능
//	    System.out.println(service.getProduct(cust[0]));
		Product[] returnPros = service.getProduct(cust[0]);
		for(Product p:returnPros)							
			System.out.println(p.getDetails());
		
	    
	    //2. 특정 고객이 구입한 상품의 maker들만 리턴하는 기능
//	    System.out.println(service.getAllProductMaker(cust[2]));
		String[] returnMakers = service.getAllProductMaker(cust[0]);
		for(String m:returnMakers)							
			System.out.println(m);
	    
	    //3. Outlet안에 있는 모든 고객을 리턴하는 기능
//	    System.out.println(service.getAllCustomer(cust));
	    Customer[] returnCustomers = service.getAllCustomer(cust);
		for(Customer r:returnCustomers)							
			System.out.println(r.getName());
	    
	    //4. 모든 고객들 중에서 특정한 고객을 검색하는 기능...ssn으로 검색
//	    System.out.println(service.findCustomerBySsn(cust, 333));
	    Customer findCustomer = service.findCustomerBySsn(cust, 333);
		System.out.println(findCustomer.getName());
	    
	    //5. 특정 고객이 구입한 물건중 최고가에 해당하는 물건의 가격을 리턴하는 기능
	    System.out.println(service.maxPriceProduct(cust[0]));	
//	    int max = service.maxPriceProduct(cust[0]);
//		System.out.println(max);
	    
	    
	    //6. 모든 고객이 구입한 물건중 특정가격 이상되는 제품들을 리턴하는 기능
//	    System.out.println(service.getMorePriceProducts(cust, 50000));
	    Product[ ] morepros = service.getMorePriceProducts(cust, 50000);
	    for(Product p : morepros) {
	    	if(p == null) continue;
	    	System.out.println(p.getDetails());
	    	}
	    		
	   
	    //7. 동일한 동네에 살고있는 고객들을 리턴하는 기능
//	    System.out.println(service.findCustomerByAddr(cust, "신사동"));
	    Customer[] findCustomers = service.findCustomerByAddr(cust, "신사동");
		for(Customer f:findCustomers) {
	    	if(f == null) continue;						
			System.out.println(f.getName());
		}
	    

	   }// main

	}//class