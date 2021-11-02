package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest {

	public static void main(String[] args) {
				
		Account acc1 = new Account(0);
		Customer cus1 = new Customer("±æµ¿", "È«");
					
		cus1.setAccount(acc1);	
		
		acc1.deposit(10000);
		acc1.withdraw(5000);

		System.out.println(cus1.getCustomer()+"´ÔÀÇ °èÁÂ ÀÜ°í´Â " + cus1.getAccount().getBalance() + "¿ø ÀÔ´Ï´Ù");

	}

}
