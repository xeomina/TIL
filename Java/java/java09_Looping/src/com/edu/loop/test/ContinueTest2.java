package com.edu.loop.test;
/*
 * Loop문 - 반복문
 *  
 * break:
 * 
 * continue:
 * 아랫문장 수행하지 말고 계속 반복해라
 * 
 */
public class ContinueTest2 {

	public static void main(String[] args) {
		int total = 0;
		
		for(int num =1; num<=100; num++) {
			if(num % 2 != 0) continue;
			total += num;
		}	//for
		
		System.out.println("1부터 10까지 홀수의 합 : "+total);	//2550

	}

}
