package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

/*
 * 1. ����, ����, �츮���� ������  ����
 * 2. james��� �̸��� ���� �ϳ� ����
 * 3. james ���� ����, ����, �츮���� ������ ������
 * 4. james ���� ������ �ִ� ���� �߿��� �������� ������ �ϳ� �޾ƿͼ� - equlas() �Լ��� ���
 *    �������� ���忡 900��, 30000�� �Ա� - 900���� �Ա� x Ȯ��
 *    5000�� ��� -> �ܾ� Ȯ��
 * 
 */

public class BankTest2 {

	public static void main(String[] args) {
		
		//1. Account Ÿ���� �迭 ����
		Account[ ] accounts = {
				new Account(1000, "����"),
				new Account(2000, "����"),
				new Account(3000, "�츮"),
		};
		
		//2. james��� ���� ����
		Customer cus = new Customer(1234,"James");
		
		//3. james�� 3���� ������ ����
		cus.setAccounts(accounts);		//Has a Relation
		
		//4. james�� ������ �ִ� ���� �߿��� ����
		Account[] reAcc = cus.getAccounts();	//�迭�� �����ͼ� �ѹ��� ���Ϲ���
		
		Account choice = null; //Local V �ʱ�ȭ
		
		for(Account acc : reAcc) {	
			if(acc.getBankName().equals("����")){		//getBankName�� ����� "����"�� ��
				choice = acc;	//���� ���� ����				
			}
		}
		
		System.out.println("Balance: "+choice.getBalance());
		System.out.println("==�������� ���忡 �Ա��� ����==");
		choice.deposit(900);
		choice.deposit(30000);
		System.out.println("Balance: "+choice.getBalance());
		
		System.out.println("==�������� ���忡 ����� ����==");
		choice.withdraw(5000);
		choice.withdraw(50000);
		System.out.println("Balance: "+choice.getBalance());
		
		System.out.println("==�������� �ܾ� Ȯ��==");
		System.out.println("Balance: "+choice.getBalance());

	}

}
