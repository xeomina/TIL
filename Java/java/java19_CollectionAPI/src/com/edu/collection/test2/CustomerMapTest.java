package com.edu.collection.test2;

import java.util.HashMap;
import java.util.Set;

import com.edu.collection.vo.Customer;

public class CustomerMapTest {

	public static void main(String[] args) {
		HashMap<String, Customer> map = new HashMap();
		map.put("111", new Customer("KANG","��ȣ��",50));
		map.put("222", new Customer("LEE","�̼���",46));
		map.put("333", new Customer("SEO","������",42));
		map.put("444", new Customer("KIM","����ö",38));
		
		//1.Ű���� 222�� ����� ã�Ƽ� ���
//		Customer c = map.get("222");
//		System.out.println(c);
		System.out.println(map.get("222"));	//overriding

			
		//2.Id�� LEE�� ����� ã�Ƽ� �� ����� �̸��� ���
		Set<String> set = map.keySet();
		for(String key : set) {
			Customer cust = map.get(key);
			if(cust.getCustId().equals("LEE"))
				System.out.println("ID�� LEE�� ����� �̸� : "+cust.getName());
		}
		
		//3.map�� ����� ��� �������� key���� ��� ���
		Set<String> keys = map.keySet();
		
		System.out.println(keys);
		
//		for(String key : keys) {
//			System.out.println(key);
//		}
		
		//4.map�� ����� ������� ���̿� ��� ���̸� ��� ���
		Set<String> set2 = map.keySet();
		
		int totalAge=0;
		for(String key : set2) {
			totalAge += map.get(key).getAge();
		}
		System.out.println("������� ��� ����: "+totalAge/map.size());
		
		

	}//main

}//class
