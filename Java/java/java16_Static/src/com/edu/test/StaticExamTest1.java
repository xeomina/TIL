package com.edu.test;
/*
 * static 1,2,3에 대한 코드
 * 1. static으로 지정된 멤버는 객체 생성할 필요 없이 바로 접근해서 사용 가능하다
 * 2. class(실행파일 - byteCode)파일이 메모리(JVM)에 로더되는 과정에서 미리 메모리에 올라간다
 * 3. static으로 지정한 변수는 local레벨에서 사용할 수 없다
 */

class Member{
	static String name = "홍길동";	//static V
	static int age = 19;			//static V
	int count = 1;					//field
	
	//static
	public static void getMember() {
		System.out.println("우윳빛깔 " + name);
	}
	
	//non-static
	public void getMember2() {
		//static은 local 레벨로 사용할 수 없다
//		static String address = "한남동";
		System.out.println("우윳빛깔 " + name);
	}
	
	//static
	public static void getMember3() {
		System.out.println("우윳빛깔 " + name);
//		count++; //non-static - 에러
	}
}

public class StaticExamTest1 {

	public static void main(String[] args) { 			//main은 static
		//Member에 있는 getMember()를 사용 - 호출
		//static으로 지정한 것들은 객체 생성 필요없이 클래스 이름.으로 바로 사용 가능 (메모리에 미리 올라감)
		Member.getMember(); 
		
//		Member.getMember2();	//static 영역에서 non-static 멤버 사용 불가 - static은 static끼리
		Member m = new Member(); //객체 생성(메모리 올린) 다음에 사용 가능
		m.getMember2();

	}

}
