/* 
 * package: 비슷한 기능을 가지고 있는 클래스 묶어주는 역할
 * Rule 
 * 1) 모든 패키지 이름은 소문자
 * 2) 상위 패키지와 하위 패키지는 '.'으로 구분
 * 3) 패키지 선언은 소스코드의 가장 윗 부분에 위치
 */

package com.edu.pro;

// class 클래스 이름 -> Greeting
/*
 * 1) 클래스 이름은 반드시 대문자로 시작
 * 2) 클래스 이름으로 파일명이 결정
 * 3) 클래스 확장자는 java
 */
public class GreetingTest { // 실행 클래스: Greeting -> GreetingTest / GreetingAppTest 로 변경해야!
	
	// method -> main method
	// main method가 있는 클래스는 실행 대상이 됨
	public static void main(String[] args) {
		// 콘솔창(System.out)에 "안녕하세요" 메세지 출력
		System.out.println("안녕하세요");
		// sysout + ctl + space -> System.out.println();

	}
}

/*
 * 위 코드는 무늬만 자바인 프로그램
 * 결과적으로 문법은 자바 문법을 사용했지만
 * OOP를 지향해서 작성한 코드가 아니기 때문에
 * 자바라 할 수 없음
 * 
 * 
 * com.edu.oop 패키지에서는
 * 위 코드를 그대로 객체지향적인 프로그램으로 바꿔볼 것
 */




