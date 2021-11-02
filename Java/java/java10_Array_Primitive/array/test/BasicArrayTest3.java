package com.edu.array.test;

public class BasicArrayTest3 {
	
	public static void main(String[] args) {
		
        //배열 선언 + 생성 + 초기화
		int[] arr = {11,22,33};
		int[ ] arr2 = {1,2,3};

		System.out.println("배열 각각의 칸에 들어있는 값: " );
		for(int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n배열 객체를 참조하는 주소값: " + arr);	
		
		System.out.println("\n=============================\n");

		arr2 = arr;
		
		System.out.println("배열 각각의 칸에 들어있는 값2: ");		
		for(int i=0; i< arr2.length; i++) 
			System.out.print(arr2[i]+" ");
		
		System.out.println("\n배열 객체를 참조하는 주소값: "+arr2);
		
		//toString()...주소값을 문자열로 리턴하는 기능
		System.out.println("배열 객체를 참조하는 주소값: "+arr2.toString());//위와 동일한 값 출력
	}
}































