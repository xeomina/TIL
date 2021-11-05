package exception.runtime.test;
/*
 * Runtime Exception
 * 1. 
 * 컴파일러가 인식을 못함
 * 컴파일은 되고 실행할 때 예외를 발생시킨다
 * 
 * 2.
 * 예외처리를 굳이 명시적으로 할 필요가 없고
 * 소스코드를 수정하기만 하면 된다
 * 
 * 
 * 명시적으로 예외 처리하는 방법
 * try{
 * 				//예외 발생 가능성 있는 코드
 * 				//만약에 예외 발생이 안되면 이 부분이 수행
 * }catch(예외 타입){
 *  			//예외를 잡았을 때 수행되는 코드
 * 				//만약에 try 블락에서 예외가 발생되면 이 부분으로 내려옴
 * }finally{
 * 				//예외 발생하든 안하든 무조건 수행되어져야 하는 코드
 * 
 * 
 * 
 */

public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String[] str= {
				"Hello JAVA",
				"No, I Mean it",
				"Nice to meet you"
		};
		
		int i=0;
		while(i<=3) {										//4가 되면 loop 빠져나옴 
			try {
				System.out.println(str[i]);					//i=0,1,2일때는 예외 x, i=3일때 예외(버그) - JVM: 발생한 타입으로 객체로 (버그도 객체로 핸들링!) -> 다시 프로그램으로
			}catch(ArrayIndexOutOfBoundsException e) {		//JVM이 만든 객체(ArrayIndexOutOfBoundsException)로 catch!!
				System.out.println("Nice Catch");			
			}
			i++;											//i=0->1->2->3->4
		}
		System.out.println("while loop the end");
	}
}
