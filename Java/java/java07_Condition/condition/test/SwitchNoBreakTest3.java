package com.edu.condition.test;
/*
 * 앞에서 배운 switch문은 
 * break 키워드를 어떻게 활용하느냐에 따라
 * 다양한 결과를 도출할 수 있다
 * 
 * 1) static한 기능을 접근하는 방법
 * 2) break 키워드 사용법
 */

/*
 * Math m = new Math();
 * m.random();
 * 
 * random()은 static한 성질로 만들어져 있기 때문에
 * 객체생성할 필요가 없음 - 미리 메모리 올라가 있다
 * 
 * Math.random(); 가능!
 * 
 */

public class SwitchNoBreakTest3 {

	public static void main(String[] args) {
//		double time = Math.random();	//0~1사이의 실수가 랜덤하게 리턴
		int time = (int)(Math.random()*4) +8;	//8~11 사이의 정수가 랜덤하게 리턴
		System.out.println("현재시각: " +time+"시");
		
		switch(time) {
		case 8:
			System.out.println("출근 준비");
//			break;
		case 9:
			System.out.println("회사 도착");
//			break;
		case 10:
			System.out.println("오전 업무");
//			break;
		case 11:
			System.out.println("외근 준비");
//			break;
			
		}
	}
}
