package exception.runtime.test;
/*
 * catch는 여러번 할 수 있다
 * 하지만 이때
 * 작은 (자식) --> 큰(부모) 순으로 해야 한다
 * 
 * 			 	Exception
 * 					|
 * 			RuntimeExeption(작은것들)
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
//			}catch(Exception e) {							//Exception으로 catch - 이미 핸들링
//				System.out.println("Nice Catch 1");		
//			}catch(ArrayIndexOutOfBoundsException e) {		//이미 catch되었기 때문에 중복으로 잡힌다 - 에러
//				System.out.println("Nice Catch 2");		
			}catch(ArrayIndexOutOfBoundsException e) {		//catch는 무조건 한번만 !
				System.out.println("Nice Catch 1");		
			}catch(Exception e) {
				System.out.println("Nice Catch2~~~!!");
			}
			i++;
		}//
		
		System.out.println("while loop the end...");
	}//
}//
