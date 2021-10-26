package com.edu.bank.vo.test;

import com.edu.bank.service.ProductService;
/* 
 * ~ Test Ŭ������
 * 1) ��ü�� ���� (==Ŭ������ ����� �޸𸮿� �ø���)
 * 2) ����� ���� (�ʵ� ������ ������ ������ �޼ҵ� ���ٸ� ����) == �޼ҵ� ȣ��
 * 
 * ProductService���� ��� �޼ҵ带 �����صξ��� ������
 * ProductService ��ü�� ���� -> �޼ҵ� ȣ��
 * 
 */
import com.edu.bank.vo.Product;

public class ProductServiceTest3 {

	public static void main(String[] args) {
		Product[] pros = {
	            new Product("�Ŷ��", 3000, 4, "���"),
	            new Product("����", 12000, 10, "���"),
	            new Product("����ũ��", 23000, 1, "LG"),
	            new Product("������", 440000, 1, "���")
		};
		
		//1.Service ��ü ����
		ProductService service = new ProductService();
		
		//2. Service�� ������ �޼ҵ带 �ϳ��� ȣ��
		
		//1)
		service.printAllProductMaker(pros);
		
		//2)
		System.out.println(service.getTotalPrice(pros));	//return �Լ��̱� ������ print
		
		//3)
		Product[] returnPros = service.getMorePrice(pros, 20000);
		for(Product pro:returnPros) {				//�迭�� ũ�Ⱑ �ٸ��� ������ Null �� ��� -> Error!
			if(pro == null) continue;				//Null�� �� �ǳʶٰ� continue
			System.out.println(pro.getDetails());
		}
		
		//4)
		Product[] returnPros2 = service.getCertainCompany(pros, "���");
		for(Product pro:returnPros2) {				
			if(pro == null) continue;				
			System.out.println(pro.getDetails());
		}
		
		//5)
		System.out.println(service.getAvgPrice(pros));
		

	   }// main

	}//class