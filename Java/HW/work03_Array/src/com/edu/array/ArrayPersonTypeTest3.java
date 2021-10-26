package com.edu.array;

import java.util.Arrays;
import java.util.Scanner;
/*
Input Sample Data
6
1 4 4 4 5 3 
*/
public class ArrayPersonTypeTest3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사람 수: ");
		int num = sc.nextInt();		//6
		
		int[] people = new int[num];
		
		System.out.print("성격 유형: ");
		
		for(int i=0; i<people.length; i++) {
			people[i] = sc.nextInt();	//1 4 4 4 5 3
		}
		
		int[] cnt = new int[num];
		
		for(int i=0; i<cnt.length; i++) {
			cnt[i] = 0;	
		}
		
		System.out.println(Arrays.toString(people));
		
		for(int i=0; i<people.length; i++) {
			cnt[people[i]]++;	
		}
		
		System.out.println(Arrays.toString(cnt));
		
		int type = 0;
		int max=cnt[0];
		for(int i=0; i<cnt.length; i++) {
			if(cnt[i]>max) {
				max = cnt[i];
				type = i+1;
				}
		}
		System.out.println("Result: " + type);
	}
}


