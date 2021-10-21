package com.edu.oop;


/*
 * 인삿말에 대한 성질과 기능을 담고 있는 클래스
 * 인삿말--? (값) -> 변수 = 값을 담는 공간
 * 인삿말을 콘솔창에 출력하는 기능-- method, 함수

 * Greeting 클래스 설계 시
 * 변수 / 기능 
 */

public class Greeting {
	public String message; // 변수 (message) 선언
	
	// method 정의 = method 선언 + method 구현
	public void printMessage() {								// method 선언
		System.out.println("Greeting Message = " + message); 	// method 구현 -> worker
	
	}
}
