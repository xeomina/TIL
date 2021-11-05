package exception.runtime.test;

import java.sql.SQLException;

public class RuntimeExceptionTest3 {

	public static void main(String[] args) {
		String[] str= {
				"Hello JAVA",
				"No, I Mean it",
				"Nice to meet you"
		};
		
		int i=0;
		while(i<=3) {										
			try { 
				System.out.println(str[i]);				//i=3¿œ∂ß JVM:ArrayIndexOutOfBoundsException¿∏∑Œ πˆ±◊ ∞¥√º ¥¯¡Æ 
			}catch(NullPointerException e) {	
				System.out.println("Nice Catch 1");		//catch æ»µ 
			}catch(ArithmeticException e) {		
				System.out.println("Nice Catch 2");		//catch æ»µ 
			}catch(NegativeArraySizeException e) {		
				System.out.println("Nice Catch 3");		//catch æ»µ  -> ∫Ò¡§ªÛ ¡æ∑·
			}
			i++;													
		}//
		
		System.out.println("while loop the end...");
	}//
}//
