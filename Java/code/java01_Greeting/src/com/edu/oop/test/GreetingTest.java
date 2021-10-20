package com.edu.oop.test;

import com.edu.oop.Greeting;

/*
 * main method를 가진 실행 클래스
 * ~~Test.java
 * 
 * 1) 객체를 생성한다 -> 클래스의 모든 요소를 메모리에 올린다
 * 2) 메모리에 올라간 변수와 method에 접근한다 
 *    변수에 접근 -> 값 할당 / method에 접근 -> 호출
 */


public class GreetingTest {

	public static void main(String[] args) {
		// 객체 생성 (객체 이름 = g) -> Greeting 클래스의 모든 요소가 메모리에 올라감 => why? 사용하려고		
		Greeting g = new Greeting();
		
		// 메모리에 올라간 멤버(변수와 method)에 접근
		g.message = "안녕하세요 여러분";	// 변수(variable)에 실제값(literal value) 할당(assign)
		g.printMessage();			// method 호출(calling)

	}
}
