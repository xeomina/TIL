package com.edu.test;

import java.util.Scanner;

/*
 * Scanner 클래스
 * 실행시 코드에 값을 직접 입력받는 것이 아니라
 * new Account(10000);
 * 
 * 실행시점에서 값을 입력받을 수 있도록 할 때 필요한 클래스가 Scanner
 */

public class ScannerTest2 {

	public static void main(String[] args) {
		
		System.out.println("입력 : ");
		
		//1. Scanner 객체를 생성 -> 메모리에 올린다
		Scanner	sc = new Scanner(System.in); //System.in: 키보드로부터 입력 받음
		
		//2. Scanner의 기능을 이용해서 값을 받아옴
		int i = sc.nextInt();		//숫자				
		int j = sc.nextInt();
		String name = sc.next();	//문자
		
		System.out.println("숫자값 : " + i + "," + j);
		System.out.println("이름 : " + name);
		

	}

}
