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
				System.out.println(str[i]);				//i=3�϶� JVM:ArrayIndexOutOfBoundsException���� ���� ��ü ���� 
			}catch(NullPointerException e) {	
				System.out.println("Nice Catch 1");		//catch �ȵ�
			}catch(ArithmeticException e) {		
				System.out.println("Nice Catch 2");		//catch �ȵ�
			}catch(NegativeArraySizeException e) {		
				System.out.println("Nice Catch 3");		//catch �ȵ� -> ������ ����
			}
			i++;													
		}//
		
		System.out.println("while loop the end...");
	}//
}//
