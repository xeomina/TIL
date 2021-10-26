package com.edu.bank.service;
/*
 * Service Ŭ����
 * Product ��ü���� �ڵ鸵�ϴ� ���(�˰���)������ �ۼ��� Ŭ����
 * 
 * 1)��� ��ǰ���� maker�� ����ϴ� ���
 * 2)��ǰ���� �� ���Ծ��� �����ϴ� ���
 * 3)Ư�� �ݾ� �̻��� �Ǵ� ��ǰ���� �����ϴ� ���
 * 4)������ ȸ�� ��ǰ�鸸 �����ϴ� ���
 * 5)������ ��ǰ�� ��հ��� �����ϴ� ���

 */

import com.edu.bank.vo.Product;

public class ProductService {			//method ���� = ����� + ������
	
/*	private Product[] pros;
	
	public ProductService(Product[] pros) {
		this.pros = pros;
	}	
*/	
	
	//1)��� ��ǰ���� maker�� ���
	public void printAllProductMaker(Product[] pros) {	//Product ��ü�� ���ڰ�����
		//��� - ��ȯ x
		System.out.println("==1.��� ��ǰ�� ��ǰ��==");
		for(Product p : pros) {
	    	System.out.println(p.getMaker());
	     };
	}
	
	//2)��ǰ���� �� ���Ծ��� ����
	public int getTotalPrice(Product[] pros) {
		System.out.println("==2.��ǰ���� �� ���Ծ�==");
		int total = 0;
		for(Product p: pros) {
			total += p.getPrice()*p.getQuantity();
		}
		return total;
	}
	
	//3)Ư�� �ݾ� �̻��� �Ǵ� ��ǰ���� ����
	public Product[] getMorePrice(Product[] pros, int price) {	//����Ÿ���� �迭 - �迭 ���� ����
		System.out.println("==3.Ư�� �ݾ� �̻� ��ǰ==");
		Product[] temp = new Product[pros.length]; //�ӽ� �迭 �����ؾ� but ������ ���� ���� -> pros.length : �迭�� ���� �� �ִ� �ִ� ������� ����
		
		int index = 0;
		for(Product p: pros) {
			if(p.getPrice()>=price) {
				temp[index++] = p;
			}
		}
		return temp;
	}
	
	//4)������ ȸ�� ��ǰ�鸸 ����
	public Product[] getCertainCompany(Product[] pros, String company) {
		System.out.println("==4.������ ȸ�� ��ǰ==");
		Product[] temp = new Product[pros.length];
		
		int index = 0;
		for(Product p:pros) {
			if(p.getCompany().equals(company)) {
				temp[index++]=p;
			}
		}
		return temp;
	}
	
	
	//5)������ ��ǰ�� ��հ� ����
	public int getAvgPrice(Product[] pros) {
		System.out.println("==5.������ ��ǰ�� ��հ�==");

		return getTotalPrice(pros)/pros.length;
	}
}
