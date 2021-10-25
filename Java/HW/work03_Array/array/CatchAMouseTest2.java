package com.edu.array;

import java.util.Scanner;

public class CatchAMouseTest2 {
	
	private static String solve(int x, int y, int z) {
		int[ ] arr= {x,y,z};
		
		if(Math.abs(arr[2]-arr[0])<Math.abs(arr[2]-arr[1])) {
			return "CatA Catch";
		}else if(Math.abs(arr[2]-arr[0])>Math.abs(arr[2]-arr[1])) {
			return "CatB Catch";
		}else return "Mouse Escapes";

	}	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//값을 순서대로 3개..catA, catB, Mouse
		
		int cata = sc.nextInt();
		int catb = sc.nextInt();
		int mouse = sc.nextInt();
		
		String result=solve(cata,catb,mouse);
		System.out.println("Result: "+result);
	}
}
