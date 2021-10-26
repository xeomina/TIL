package com.edu.condition.test;

import java.util.Scanner;

public class GradeIfTest1 {

	public static void main(String[] args) {
//		int grade = 88; //local V - 컴파일시 변수 할당 -> 실행시로 변경해줘야 함
		
		System.out.println("점수 입력 : ");
		Scanner	sc = new Scanner(System.in); 
		int grade = sc.nextInt();				
		
		
//		if(grade >= 90 & grade <= 100) {
//			System.out.println("A grade");
//		}else if(grade >= 80 & grade < 90) {
//			System.out.println("B grade");
//		}else if(grade >= 70 & grade < 80) {
//			System.out.println("C grade");
//		}else {
//			System.out.println("Try Again");
//		}
		
		
		if(grade >= 90 & grade <=100) 
			System.out.println("A grade");			
		else if(grade >=80 & grade < 90) 
			System.out.println("B grade");
		else if(grade >=70 & grade < 80)
			System.out.println("C grade");
		else 
			System.out.println("Try Again");	// {} 생략가능

		
	}	//main
}	//class
