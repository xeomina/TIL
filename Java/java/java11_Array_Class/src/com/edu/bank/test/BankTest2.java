package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

/*
 * 1. 신한, 국민, 우리은행 통장을  생성
 * 2. james라는 이름의 고객을 하나 생성
 * 3. james 고객이 신한, 국민, 우리은행 통장을 개설함
 * 4. james 고객이 가지고 있는 통장 중에서 신한은행 통장을 하나 받아와서 - equlas() 함수를 사용
 *    신한은행 통장에 900원, 30000원 입금 - 900원은 입금 x 확인
 *    5000원 출금 -> 잔액 확인
 * 
 */

public class BankTest2 {

	public static void main(String[] args) {
		
		//1. Account 타입의 배열 생성
		Account[ ] accounts = {
				new Account(1000, "신한"),
				new Account(2000, "국민"),
				new Account(3000, "우리"),
		};
		
		//2. james라는 고객을 생성
		Customer cus = new Customer(1234,"James");
		
		//3. james가 3개의 통장을 가짐
		cus.setAccounts(accounts);		//Has a Relation
		
		//4. james가 가지고 있는 통장 중에서 신한
		Account[] reAcc = cus.getAccounts();	//배열로 가져와서 한번에 리턴받음
		
		Account choice = null; //Local V 초기화
		
		for(Account acc : reAcc) {	
			if(acc.getBankName().equals("신한")){		//getBankName의 결과가 "신한"일 때
				choice = acc;	//신한 은행 선택				
			}
		}
		
		System.out.println("Balance: "+choice.getBalance());
		System.out.println("==신한은행 통장에 입금을 진행==");
		choice.deposit(900);
		choice.deposit(30000);
		System.out.println("Balance: "+choice.getBalance());
		
		System.out.println("==신한은행 통장에 출금을 진행==");
		choice.withdraw(5000);
		choice.withdraw(50000);
		System.out.println("Balance: "+choice.getBalance());
		
		System.out.println("==신한은행 잔액 확인==");
		System.out.println("Balance: "+choice.getBalance());

	}

}
