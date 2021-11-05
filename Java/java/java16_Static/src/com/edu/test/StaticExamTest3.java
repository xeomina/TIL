package com.edu.test;
/*
 * static 키워드는 상수값을 지정할 때 쓰이는 final 키워드와 함께 사용되는 경우가 많다
 * 
 * Usage Modifier
 * final static abstract
 * 
 * 1.final
 * "내가 마지막이야" 라는 의미를 가지는 키워드이다
 * final + 변수 : 내가 마지막 변수야 -> 상수값
 * final + 메소드 : 내가 마지막 메소드야 -> 오버라이딩 금지
 * final + 클래스 : 내가 마지막 클래스야 -> 상속 금지
 * 
 * final과 static 순서는 상관없음
 * 
 */

class A{
	public final static int BASIC_SALAY = 1000;
	public final String test() {
		return "Overriding 금지";
	}
	
final class B{
	
}

//class C extends B{}

class D extends A{
//	public String test() {
//		return "Overriding 금지"+100;
//	BASIC_SALAY = 2000;
}

}
public class StaticExamTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
