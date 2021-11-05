package exception.runtime.test;
/*
 * catch는 여러번 할 수 있다
 * 하지만 그 중에서 하나의 catch만 수행된다
 * 
 * 
 */

public class RuntimeExceptionTest2 {

	public static void main(String[] args) {
		String[] str= {
				"Hello JAVA",
				"No, I Mean it",
				"Nice to meet you"
		};
		
		int i=0;
		while(i<=3) {										
			try { 
				System.out.println(str[i]);				//i=3일때 JVM:ArrayIndexOutOfBoundsException으로 버그 객체 던져 
			}catch(NullPointerException e) {	
				System.out.println("Nice Catch 1");		//catch 안됨
			}catch(ArithmeticException e) {		
				System.out.println("Nice Catch 2");		//catch 안됨
			}catch(ArrayIndexOutOfBoundsException e) {		
				System.out.println("Nice Catch 3");		//catch 됨
			}
			i++;											
		}
		System.out.println("while loop the end");
	}
}
