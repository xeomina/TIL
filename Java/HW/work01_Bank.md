Account.java

```java
package com.edu.bank;

public class Account {
	public double balance; 
	
	public Account(double balance){
		this.balance=balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(int amt){
		balance += amt;
		System.out.println(amt + "원 저축");
	}
	
	public void withdraw(int amt){
		balance -= amt;
		System.out.println(amt + "원 출금");
	}
}
```



Customer.java

```java
package com.edu.bank;

public class Customer {
	String firstName;
	String lastName;
	Account account;
	
	public Customer(){}
	public Customer(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;	
	}
	
	public void setAccount(Account acc) {
		this.account = acc;
	}
	
	public Account getAccount() {
		return account;		
	}
	
	public String getCustomer() {
		return firstName + " " + lastName;		
	}

}
```



BankTest.java

```java
package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest {

	public static void main(String[] args) {
				
		Account acc1 = new Account(0);
		Customer cus1 = new Customer("길동", "홍");
					
		cus1.setAccount(acc1);	
		
		acc1.deposit(10000);
		acc1.withdraw(5000);

		System.out.println(cus1.getCustomer()+"님의 계좌 잔고는 " + cus1.getAccount().getBalance() + "원 입니다");

	}

}
```



Console

```
10000원 저축
5000원 출금
길동 홍님의 계좌 잔고는 5000.0원 입니다
```

