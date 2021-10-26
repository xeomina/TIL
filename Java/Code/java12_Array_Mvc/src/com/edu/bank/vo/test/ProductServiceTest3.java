package com.edu.bank.vo.test;

import com.edu.bank.service.ProductService;
/* 
 * ~ Test 클래스는
 * 1) 객체를 생성 (==클래스의 멤버를 메모리에 올리고)
 * 2) 멤버에 접근 (필드 접근이 막혔기 때문에 메소드 접근만 가능) == 메소드 호출
 * 
 * ProductService에서 모든 메소드를 정의해두었기 때문에
 * ProductService 객체를 생성 -> 메소드 호출
 * 
 */
import com.edu.bank.vo.Product;

public class ProductServiceTest3 {

	public static void main(String[] args) {
		Product[] pros = {
	            new Product("신라면", 3000, 4, "농심"),
	            new Product("생수", 12000, 10, "농심"),
	            new Product("옥시크린", 23000, 1, "LG"),
	            new Product("정수기", 440000, 1, "대우")
		};
		
		//1.Service 객체 생성
		ProductService service = new ProductService();
		
		//2. Service의 구현된 메소드를 하나씩 호출
		
		//1)
		service.printAllProductMaker(pros);
		
		//2)
		System.out.println(service.getTotalPrice(pros));	//return 함수이기 때문에 print
		
		//3)
		Product[] returnPros = service.getMorePrice(pros, 20000);
		for(Product pro:returnPros) {				//배열의 크기가 다르기 때문에 Null 값 출력 -> Error!
			if(pro == null) continue;				//Null일 때 건너뛰고 continue
			System.out.println(pro.getDetails());
		}
		
		//4)
		Product[] returnPros2 = service.getCertainCompany(pros, "농심");
		for(Product pro:returnPros2) {				
			if(pro == null) continue;				
			System.out.println(pro.getDetails());
		}
		
		//5)
		System.out.println(service.getAvgPrice(pros));
		

	   }// main

	}//class