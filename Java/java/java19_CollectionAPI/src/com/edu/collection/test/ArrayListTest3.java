package com.edu.collection.test;

import java.util.ArrayList;
import java.util.List;

/*
 *  	List
 * 		 |
 *    ArrayList		의 데이터 저장 방법을 알아보는 로직을 작성
 * 순서가 있다 : 내부적으로 index로 관리된다
 * 데이터 중복을 허용한다
 * 
 * 
 */
public class ArrayListTest3 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();  //<> , <String> 둘다 상관없음.
		
		list.add("강호동");
		list.add("이수근");
		list.add("강호동");
		list.add("김영철");
		list.add("서장훈");
		
		System.out.println(list); 	//순서가 있음(입력한 순서대로 출력), 중복 허용
		
		//2번째(index 1)데이터 삭제
		String removeName=list.remove(1); //삭제된 데이터 자체가 리턴
		System.out.println(removeName+" 님을 삭제");
		System.out.println(list);
		
		//가장 첫번째에 김희철을 추가
		list.add(0,"김희철");
		System.out.println(list);
		
		//list의 멤버들 중에서 이름이 서장훈인 사람을 찾아서 출력
		//for, equals, get
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals("서장훈"))
				System.out.println(list.get(i));
					}
		
		
				

	}

}
