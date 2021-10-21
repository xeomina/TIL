MyDate.java

```java
package com.edu.capsul;

public class MyDate {
	
	private int month;
	private int day;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {

		if(1<=month & month<=12) {
		this.month = month;
		}else {
			System.out.println("1~12월 사이를 입력하세요");
		}
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {		
		
		switch(month) {			
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if(1<=day & day<=31) {
				this.day = day;
				}else {
					System.out.println("1~31일 사이를 입력하세요");
				}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if(1<=day & day<=30) {
				this.day = day;
				}else {
					System.out.println("1~30일 사이를 입력하세요");
				}
			break;
		case 2:
			if(1<=day & day<=28) {
				this.day = day;
				}else {
					System.out.println("1~28일 사이를 입력하세요");
				}
			break;
			
			}	//switch
	}
}
```



MyDateTest.java

```java
package com.edu.capsul.test;

import java.util.Scanner;

import com.edu.capsul.MyDate;

public class MyDateTest {
	public static void main(String[] args) {
		
		MyDate md = new MyDate();

		Scanner	sc = new Scanner(System.in); 
		
		System.out.println("월 입력 : ");
		md.setMonth(sc.nextInt());			
		System.out.println("일 입력 : ");
		md.setDay(sc.nextInt());
		
		if(md.getMonth()==0 | md.getDay()==0) 
//			System.out.println("0이 포함되므로 날짜가 출력되지 않습니다");
			System.exit(0);
		else
			System.out.println("오늘의 날짜: "+md.getMonth()+"월" + md.getDay()+"일");			
	}
}
```



```
월 입력 : 
9
일 입력 : 
4
오늘의 날짜: 9월4일
```

```
월 입력 : 
2
일 입력 : 
29
1~28일 사이를 입력하세요
```

