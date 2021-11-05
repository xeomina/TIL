package exception.runtime.test;
/*
 * catch�� ������ �� �� �ִ�
 * ������ �̶�
 * ���� (�ڽ�) --> ū(�θ�) ������ �ؾ� �Ѵ�
 * 
 * 			 	Exception
 * 					|
 * 			RuntimeExeption(�����͵�)
 *		--- ArrayIndexOutOfBoundsException
 *		--- ArithmeticException
 *		--- NullPointerException   
 *           
 */

public class RuntimeExceptionTest4 {

	public static void main(String[] args) {
		String[] str= {
				"Hello JAVA",
				"No, I Mean it",
				"Nice to meet you"
		};
		
		int i=0;
		while(i<=3) {										
			try { 
				System.out.println(str[i]);				
//			}catch(Exception e) {							//Exception���� catch - �̹� �ڵ鸵
//				System.out.println("Nice Catch 1");		
//			}catch(ArrayIndexOutOfBoundsException e) {		//�̹� catch�Ǿ��� ������ �ߺ����� ������ - ����
//				System.out.println("Nice Catch 2");		
			}catch(ArrayIndexOutOfBoundsException e) {		//catch�� ������ �ѹ��� !
				System.out.println("Nice Catch 1");		
			}catch(Exception e) {
				System.out.println("Nice Catch2~~~!!");
			}
			i++;
		}//
		
		System.out.println("while loop the end...");
	}//
}//
