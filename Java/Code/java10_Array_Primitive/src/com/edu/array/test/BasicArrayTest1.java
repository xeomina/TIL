package com.edu.array.test;

/*
 * Array
 * 같은 데이타 타입을 가지는 서로 다른 값들을
 * 하나의 변수로 처리하는 것
 * 
 * Array 선언, 생성, 초기화
 * 
 * 1. 선언               
 * int[ ] arr;    
 * 2. 생성(반드시 사이즈를 명시) 
 * arr = new int[3];
 * 3. 초기화
 * arr[0]=11; arr[1] = 22; arr[2] = 33;
 * 
 */

public class BasicArrayTest1 {
	public static void main(String[] args) {
		//1. 배열선언
		int[] arr;
		
		//2. 배열생성
		arr = new int[3];
		
		//3. 초기화
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		
		System.out.println("배열 각각의 칸에 들어있는 값: " );
        
//        for(int i=0; i<3; i++)
            
		for(int i=0; i< arr.length; i++) {		////length: 배열의 사이즈 리턴
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n배열 객체를 참조하는 주소값: " + arr);	
	}
}













