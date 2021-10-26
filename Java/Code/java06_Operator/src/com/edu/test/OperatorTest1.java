package com.edu.test;

class Operator{
	public boolean test1() {
		System.out.println("test1()...calling");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2()...calling");
		return false;
	}
}

public class OperatorTest1 {

	public static void main(String[] args) {
		//Local Variable : method 영역 안에서만 사용 가능
		int i = 10;
		int j = 8;
		
		System.out.println(i == j);		//false
		System.out.println(i != j);		//true
		
		//%: 특정 값을 어떤 값으로 나눌때 나머지
		System.out.println(i % j);		//2
		
		//++: 1씩 값을 증가시키는 연산자
		int x = 10; 					//local V 초기화 (선언+할당)
		System.out.println(x++);		//10
		System.out.println(x);			//11 -> 1이 나중에 증가
		
		int y = 10; 					
		System.out.println(++y);		//11 -> 1이 먼저 증가
		System.out.println(y);			//11 
		
		//--: 1씩 값을 감소시키는 연산자
		int z = 10; 					
		System.out.println(z--);		//10
		System.out.println(z);			//9 -> 1이 나중에 감소
		
	}
//i = 100; -> error. local V이기 때문에 반드시 main(){} 안에서만 사용
}