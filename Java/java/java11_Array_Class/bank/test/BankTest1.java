package com.edu.bank.test;

import com.edu.bank.Account;

public class BankTest1 {

	public static void main(String[] args) {
		
/*		// 1.accounts��� �̸����� Account Ÿ���� �迭 ���� (������ 3)
		Account[ ] accounts = new Account[3];		
		
		//2. ������ ĭ�� ����, ����, �츮���� ������ ����
		accounts[0] = new Account(10000, "����");			//��ü ������ ��� �Ҵ� - Heap�� ��ü �ö� 
		accounts[1] = new Account(5000, "����");
		accounts[2] = new Account(7000, "�츮");
		*/
		
/*
 * ���� ���� �ʱ�ȭ �Ѳ�����
 * �⺻�� Ÿ���� �迭������ ���� ������ ��ü�� �ǹ�������
 * Ŭ���� Ÿ���� �迭������ ���� ������ ��ü�� �ȴ�
 * 
 */
		
		Account[ ] accounts = {
				new Account(10000, "����"),
				new Account(5000, "����"),
				new Account(7000, "�츮"),
		};
		
		
		//3. for���� �̿��ؼ� �迭�ȿ� �ִ� Account ������ ���
		for(Account account : accounts) 				// �ʱ�ĸ�: account�ȿ��� loop
			System.out.println(account.getDetails());	

	}

}
