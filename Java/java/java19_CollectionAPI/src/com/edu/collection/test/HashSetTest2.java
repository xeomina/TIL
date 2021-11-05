package com.edu.collection.test;

import java.util.HashSet;

/*
 * 		Set
 * 		 |
 *    HashSet		의 데이터 저장 방법을 알아보는 로직을 작성
 * 순서가 없다 : 내부적으로 index 관리가 안된다
 * 중복을 허용하지 않는다 : 설사 중복이 되었다 하더라도 저장되지 않는다
 * 
 * 	add(E)
 *  size()
 *  remove(E) boolean
 *  clear()
 *  isEmpty()
 *  contains()
 * 
 * 
 */
public class HashSetTest2 {

	public static void main(String[] args) {
		//<E> Set안에 들어있는 객체 타입을 미리 지정할 수 있다
		HashSet<String> set = new HashSet<String>();
		set.add("서장훈");
		set.add("이수근");
		set.add("강호동");
		set.add("강호동");
		set.add("김희철");
		
		System.out.println("몇명? " +set.size()); 	//4 -> 중복허용x
		
		//Set안에 들어있는 데이터를 출력	
		//1.입력된 순서대로 출력되지 않는다 - 순서가 없음을 확인
		//2.Collection에서는 toString()이 데이터를 리턴하도록 자체적으로 오버라이딩 되어져있다
		System.out.println(set.toString());			//[서장훈, 강호동, 이수근, 김희철]
		System.out.println(set);					//위와 동일 - 주소값 x
		
		//김영철이 포함되어져 있는지 여부
		System.out.println("김영철이 포함? "+set.contains("김영철"));	//false
		
		//강호동을 삭제
		set.remove("강호동");
		System.out.println(set);	//[서장훈, 이수근, 김희철]
		
		//set에 저장된 모든 데이터를 삭제
		set.clear();
		
		System.out.println("set안이 다 비워져 있는가? "+set.isEmpty());		//true
		System.out.println(set);	//[]
		
		

	}

}
