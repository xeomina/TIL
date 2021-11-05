package com.edu.collection.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * 				Map
 * 		  |				|
 *    Hashtable		HashMap
 * 		  |				|
 * 	  Properties
 *    (key,value
 *   ��� ���ڿ��� ����)
 *     
 * put(key,value)
 * get(key) :value
 * remove(key) : value
 * remove(Object key,Object value) : boolean
 * keySet() : Set
 * 
 * 
 * 
 *     
 */
public class HashMapTest4 {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("��ȣ��", 90);
		map.put("������", 95);
		map.put("�̼���", 100);
		map.put("����ö", 90);
		map.put("�迵ö", 92);
		
		//1. map�� ����� ��� Ű ���� �޾ƿ´�
		Set<String> set = map.keySet();
		//2.Set�� ����� key���� �̾Ƴ���
		//1)Iterator
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String name = it.next();
			int score = map.get(name);
			System.out.println(name+": "+score);
		}
		
		System.out.println("=========================");
		
		//2.for��
//		for(int i=0;i<set.size();i++) 	//index���̶� �Ұ�
		int total = 0;
		for(String name : set) {
			int score = map.get(name);
			System.out.println(name+": "+score);
			total += score;
		}
		System.out.println("=========================");
		System.out.println("Total: "+total);
		System.out.println("Avg: "+total/map.size());
		
		
		System.out.println("=========================");
		
		
		Collection<Integer> scores = map.values();
		int total2 = 0;
		for(int score : scores) {
			System.out.println("score: "+score);
			total2 += score;
		}
		System.out.println("=========================");
		System.out.println("Total: "+total2);
		System.out.println("Avg: "+total2/scores.size());
		
		System.out.println("=========================");
		System.out.println("Max: "+Collections.max(scores));
		System.out.println("Min: "+Collections.min(scores));
		
		
	}

}
