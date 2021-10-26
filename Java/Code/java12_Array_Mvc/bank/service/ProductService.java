package com.edu.bank.service;
/*
 * Service 클래스
 * Product 객체들을 핸들링하는 기능(알고리즘)만으로 작성된 클래스
 * 
 * 1)모든 상품들의 maker를 출력하는 기능
 * 2)상품들의 총 구입액을 리턴하는 기능
 * 3)특정 금액 이상이 되는 제품들을 리턴하는 기능
 * 4)동일한 회사 제품들만 리턴하는 기능
 * 5)구입한 상품의 평균가를 리턴하는 기능

 */

import com.edu.bank.vo.Product;

public class ProductService {			//method 정의 = 선언부 + 구현부
	
/*	private Product[] pros;
	
	public ProductService(Product[] pros) {
		this.pros = pros;
	}	
*/	
	
	//1)모든 상품들의 maker를 출력
	public void printAllProductMaker(Product[] pros) {	//Product 객체를 인자값으로
		//출력 - 반환 x
		System.out.println("==1.모든 제품의 상품명==");
		for(Product p : pros) {
	    	System.out.println(p.getMaker());
	     };
	}
	
	//2)상품들의 총 구입액을 리턴
	public int getTotalPrice(Product[] pros) {
		System.out.println("==2.상품들의 총 구입액==");
		int total = 0;
		for(Product p: pros) {
			total += p.getPrice()*p.getQuantity();
		}
		return total;
	}
	
	//3)특정 금액 이상이 되는 제품들을 리턴
	public Product[] getMorePrice(Product[] pros, int price) {	//리턴타입이 배열 - 배열 먼저 생성
		System.out.println("==3.특정 금액 이상 상품==");
		Product[] temp = new Product[pros.length]; //임시 배열 생성해야 but 사이즈 아직 미정 -> pros.length : 배열이 가질 수 있는 최대 사이즈로 생성
		
		int index = 0;
		for(Product p: pros) {
			if(p.getPrice()>=price) {
				temp[index++] = p;
			}
		}
		return temp;
	}
	
	//4)동일한 회사 제품들만 리턴
	public Product[] getCertainCompany(Product[] pros, String company) {
		System.out.println("==4.동일한 회사 제품==");
		Product[] temp = new Product[pros.length];
		
		int index = 0;
		for(Product p:pros) {
			if(p.getCompany().equals(company)) {
				temp[index++]=p;
			}
		}
		return temp;
	}
	
	
	//5)구입한 상품의 평균가 리턴
	public int getAvgPrice(Product[] pros) {
		System.out.println("==5.구입한 상품의 평균가==");

		return getTotalPrice(pros)/pros.length;
	}
}
