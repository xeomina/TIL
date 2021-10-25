package com.edu.bank.test;

import com.edu.bank.Account;

public class BankTest1 {

	public static void main(String[] args) {
		
/*		// 1.accounts라는 이름으로 Account 타입의 배열 생성 (사이즈 3)
		Account[ ] accounts = new Account[3];		
		
		//2. 각각의 칸에 신한, 국민, 우리은행 통장을 생성
		accounts[0] = new Account(10000, "신한");			//객체 생성한 결과 할당 - Heap에 객체 올라감 
		accounts[1] = new Account(5000, "국민");
		accounts[2] = new Account(7000, "우리");
		*/
		
/*
 * 선언 생성 초기화 한꺼번에
 * 기본형 타입의 배열에서의 값은 데이터 자체를 의미하지만
 * 클래스 타입의 배열에서의 값은 생성된 객체가 된다
 * 
 */
		
		Account[ ] accounts = {
				new Account(10000, "신한"),
				new Account(5000, "국민"),
				new Account(7000, "우리"),
		};
		
		
		//3. for문을 이용해서 배열안에 있는 Account 정보를 출력
		for(Account account : accounts) 				// 초기식만: account안에서 loop
			System.out.println(account.getDetails());	

	}

}
