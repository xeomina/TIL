package com.edu.capsul.test;

import java.util.Scanner;

/* Encapsulation
 * 1.Field 값은  private으로 설정하여 외부(다른 클래스)로 부터 직접 접근을 막는다
 * 2.set() / get() method를 public으로 설정하여 Field 값을 소통
 * 3.통로로 활용되는 method내에서 정보 보호를 위해 필요한 제어문과 같은 로직을 넣는다
 * 
 */
import com.edu.capsul.MyDate;

public class MyDateTest {
	public static void main(String[] args) {
		
		MyDate md = new MyDate();

		Scanner	sc = new Scanner(System.in); 
		
		System.out.println("월 입력 : ");
		md.setMonth(sc.nextInt());			
		System.out.println("일 입력 : ");
		md.setDay(sc.nextInt());
		
		//출력될 때 0값 출력되지 않도록 주의
		if(md.getMonth()==0 | md.getDay()==0) 
//			System.out.println("0이 포함되므로 날짜가 출력되지 않습니다");
			System.exit(0);
		else
			System.out.println("오늘의 날짜: "+md.getMonth()+"월" + md.getDay()+"일");
			
	}

}
