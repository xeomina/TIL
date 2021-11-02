package com.edu.bank.vo.test;

import com.edu.bank.vo.Product;

public class ProductArrayTest2 {

	public static void main(String[] args) {
		Product[] pros = {
	            new Product("신라면", 3000, 4, "농심"),
	            new Product("생수", 12000, 10, "농심"),
	            new Product("옥시크린", 23000, 1, "LG"),
	            new Product("정수기", 440000, 1, "대우")
		};
		
		System.out.println("==1.상품들의 메이커 출력==");
	    for(Product pro: pros) {
	    	System.out.println(pro.getMaker());
	     }
	      
		System.out.println("==2.10만원 이상 상품들의 메이커와 가격 출력==");
	    for(Product pro: pros) {
	    	if(pro.getPrice()>=100000)
	    		System.out.println(pro.getMaker() + ": " +pro.getPrice());
	     }
	      
		System.out.println("==3.구매한 모든 상품의 총 가격 출력==");
		
		int total = 0;
		for(Product pro: pros) {
			total += pro.getPrice()*pro.getQuantity();
			}
	     
	    System.out.println("총합: " + total);
	    
	   }// main
	}//class