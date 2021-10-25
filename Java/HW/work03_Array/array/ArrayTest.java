package com.edu.array;

public class ArrayTest {
	static int[] list = { 34, 23, 64, 25, 12, 75, 22, 88, 53, 37 };
	
	static void print(int[] list) {
		for(int i=0;i<list.length;i++) {
		System.out.print(list[i] + " ");
		}
		System.out.println("");
	}
	
	static int total = 0;
	static void total(int[] list) { 
		for(int i=0;i<list.length;i++) {
			total += list[i];
		}
		System.out.println("배열의 합 : " + total);
	}		
	
	static void average(int[] list) {	
		System.out.println("배열의 평균 : " + total/list.length);
	}	
	
	static int min = list[0];
	static void minimum(int[] list) { 
		for(int i=0;i<list.length;i++) {
			if(min > list[i])
				min = list[i];
		}
		System.out.println("배열의 최솟값 : " + min);
	}
	
	static void selectSort(int[] list) {
		for(int i=0; i<list.length; i++) {
			for(int j=i+1; j<list.length; j++) {
				if(list[i] > list[j]) { 
					int tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
			}
		} 
		print(list);
	}

	
	
	public static void main(String[] args) {		
		print(list);
		total(list);
		average(list);
		minimum(list);
		selectSort(list);
	}
}
