ArrayTest.java

```java
package com.edu.array;

public class ArrayTest {
	static int[] list = { 34, 23, 64, 25, 12, 75, 22, 88, 53, 37 };
	
	static void print(int[] list) {
		for(int i=0;i<list.length;i++) {
		System.out.print(list[i] + " ");
		}
		System.out.println("");
	}
	
	static int total = 0;
	static void total(int[] list) { 
		for(int i=0;i<list.length;i++) {
			total += list[i];
		}
		System.out.println("배열의 합 : " + total);
	}		
	
	static void average(int[] list) {	
		System.out.println("배열의 평균 : " + total/list.length);
	}	
	
	static int min = list[0];
	static void minimum(int[] list) { 
		for(int i=0;i<list.length;i++) {
			if(min > list[i])
				min = list[i];
		}
		System.out.println("배열의 최솟값 : " + min);
	}
	
	static void selectSort(int[] list) {
		for(int i=0; i<list.length; i++) {
			for(int j=i+1; j<list.length; j++) {
				if(list[i] > list[j]) { 
					int tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
			}
		} 
		print(list);
	}
	
	public static void main(String[] args) {		
		print(list);
		total(list);
		average(list);
		minimum(list);
		selectSort(list);
	}
}
```

```
34 23 64 25 12 75 22 88 53 37 
배열의 합 : 433
배열의 평균 : 43
배열의 최솟값 : 12
12 22 23 25 34 37 53 64 75 88 
```



ArrayMaxAndMinTest1.java

```java
package com.edu.array;

public class ArrayMaxAndMinTest1 {

	public static void main(String[] args) {
		int[] scores = {79,88,91,44,100,55,95};
		
		//scores 안에 들어있는 점수 중에서 가장 잘한 성적과 가장 못받은 성적을 찾아서 출력
		//가장 잘한 성적 -> MAX | 가장 못한 성적 -> MIN
		
		int min = scores[0]; //초기화시 가장 첫번째를 기준으로 삼는 것이 좋다. 
		int max = scores[0];
		
		//for문과 if문을 사용해서 로직을 작성.
		for(int i=0; i< scores.length; i++) {
			if(scores[i] < min)min =scores[i];
			if(scores[i] > max)max =scores[i];
		}
		System.out.println("최댓값: "+max);
		System.out.println("최솟값: "+min);
	}
}
```

```
최댓값: 100
최솟값: 44
```



CatchAMouseTest2.java

```java
package com.edu.array;

import java.util.Scanner;

public class CatchAMouseTest2 {
	
	private static String solve(int x, int y, int z) {
		int[ ] arr= {x,y,z};
		
		if(Math.abs(arr[2]-arr[0])<Math.abs(arr[2]-arr[1])) {
			return "CatA Catch";
		}else if(Math.abs(arr[2]-arr[0])>Math.abs(arr[2]-arr[1])) {
			return "CatB Catch";
		}else return "Mouse Escapes";

	}	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//값을 순서대로 3개..catA, catB, Mouse
		
		int cata = sc.nextInt();
		int catb = sc.nextInt();
		int mouse = sc.nextInt();
		
		String result=solve(cata,catb,mouse);
		System.out.println("Result: "+result);
	}
}
```

```
1 2 3
Result: CatB Catch
```

```
1 3 2
Result: Mouse Escapes
```

```
23 100000 6789
Result: CatA Catch
```



ArrayPersonTypeTest3.java

```java
package com.edu.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPersonTypeTest3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사람 수: ");
		int num = sc.nextInt();		//6
		
		int[] people = new int[num];
		
		System.out.print("성격 유형: ");
		
		for(int i=0; i<people.length; i++) {
			people[i] = sc.nextInt();	//1 4 4 4 5 3
		}
		
		int[] cnt = new int[num];
		
		for(int i=0; i<cnt.length; i++) {
			cnt[i] = 0;	
		}
		
		System.out.println(Arrays.toString(people));
		
		for(int i=0; i<people.length; i++) {
			cnt[people[i]-1]++;	
		}
		
		System.out.println(Arrays.toString(cnt));
		
		int type = 0;
		int max=cnt[0];
		for(int i=0; i<cnt.length; i++) {
			if(cnt[i]>max) {
				max = cnt[i];
				type = i+1;
				}
		}
		System.out.println("Result: " + type);
	}
}
```

```
사람 수: 6
성격 유형: 1 4 4 4 5 3
[1, 4, 4, 4, 5, 3]
[1, 0, 1, 3, 1, 0]
Result: 4
```





