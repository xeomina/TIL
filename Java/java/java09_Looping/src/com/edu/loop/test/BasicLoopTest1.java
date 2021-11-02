package com.edu.loop.test;
/*
 * Loop문 - 반복문
 * 
 * for, while
 * 
 * 참인 조건을 만족하는 동안에
 * 코드블락을 반복적으로 수행하는 문장
 * 
 * 1. for문
 * 
 * <Syntax>
 * for(초기치; 조건문; 증가치)
 * for(initialization;boolean expression;update){}
 */

public class BasicLoopTest1 {

	public static void main(String[] args) {
		System.out.println("=========for=========");
		
		for(int i=0; i<10; i++) {
			System.out.println("for 1 : "+i); // ++i: 0부터 시작은 똑같음
		}

		for(int i=1, j=1; i<10 &j<10; i++) {
			System.out.println("for 2 : "+i);	
		}
		
/* 2. while 문
 * 
 * <Syntax>
 * 초기화
 * while (조건문) {...}
 * 
 * initialization
 * while(boolean expression;){}
 */
		
		System.out.println("=========while=========");
		
		int i = 10;
		while (i>0) {
		    System.out.println("while 1 : "+i);
		    i--;
	    }
	}
}











