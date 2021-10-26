package com.edu.array.test;
/*
 * 배열은 Resizing 안됨
 * 이미 만든 배열 객체 사이즈를 수정하게 되면 새로운 객체가 생성됨
 * 한번 배열을 만들때 사이즈를 넉넉히 !
 *  
 * 대신 다른 사이즈를 가진 배열의 내용을 복사하는 것은 가능
 * System.arraycopy()
 */
public class BasicArrayCopyTest4 {
	public static void main(String[] args) {
		int[] target = {1,2,3,4,5,6};
        
		//1.기본 for
		for(int i=0; i<target.length;i++) System.out.println(target[i]+ " ");
        
		//2.for in(for each)
		for(int i : target) System.out.println(i+" ");
		
		target = new int[10];	//3.배열 사이즈 늘리기
		target[6]=11;
		target[7]=22;
		target[8]=33;
		target[9]=44;
		
		System.out.println("=======================");
		
		for(int i : target) System.out.print(i+" ");
	}
}












