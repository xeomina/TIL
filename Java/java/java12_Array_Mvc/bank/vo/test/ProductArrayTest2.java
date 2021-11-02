package com.edu.bank.vo.test;

import com.edu.bank.vo.Product;

public class ProductArrayTest2 {

	public static void main(String[] args) {
		Product[] pros = {
	            new Product("�Ŷ��", 3000, 4, "���"),
	            new Product("����", 12000, 10, "���"),
	            new Product("����ũ��", 23000, 1, "LG"),
	            new Product("������", 440000, 1, "���")
		};
		
		System.out.println("==1.��ǰ���� ����Ŀ ���==");
	    for(Product pro: pros) {
	    	System.out.println(pro.getMaker());
	     }
	      
		System.out.println("==2.10���� �̻� ��ǰ���� ����Ŀ�� ���� ���==");
	    for(Product pro: pros) {
	    	if(pro.getPrice()>=100000)
	    		System.out.println(pro.getMaker() + ": " +pro.getPrice());
	     }
	      
		System.out.println("==3.������ ��� ��ǰ�� �� ���� ���==");
		
		int total = 0;
		for(Product pro: pros) {
			total += pro.getPrice()*pro.getQuantity();
			}
	     
	    System.out.println("����: " + total);
	    
	   }// main
	}//class