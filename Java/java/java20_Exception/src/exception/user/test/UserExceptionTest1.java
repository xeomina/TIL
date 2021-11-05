package exception.user.test;
/*
 * 사용자 정의 예외
 * User exception
 * 
 * 1. 내가 직접 Exception 클래스를 정의해서 사용
 * 2. 어떤 특정한 조건이 되었을 때 내가 고의적으로 예외를 발생시키는 것
 * 	  -> 사용자 정의 Exception은 하나의 강력한 제어문으로 사용된다
 * 
 */

//해당 클래스를 Exception으로 만들려면 어떻게 선언?
class ZeroDevide extends Exception{			//Exception 상속
   ZeroDevide(){
	   this("This is ZeroDevide Exception");
	   }
   ZeroDevide(String message){				//생성자 오버로딩
	      super(message);
	   }

	
} //class

class User{
	//
//	public void go() throws ArithmeticException{				//4) go 실행 
	public void go() throws ZeroDevide{				
		//스캐너로 i,j값을 실행시점에 입력받는 상황
		int i=10; int j=0;										//5) 변수할당
		System.out.println("1. i,j에 입력된 값으로 연산을 진행합니다...");	//6) 2번째 출력
		if(j==0) {												//7) true
			//ArithmeticException을 발발시켜야 한다
//			throw new ArithmeticException();					//8) 폭탄 터져 -> 던져
//			throw new ZeroDevide("분모가 0이면 에러");				//사용자 정의 - message error
			throw new ZeroDevide();				
		}
		
		//이 부분에서 i/j (10/0) ..ArithmeticException .. 이런 연산이 진행되는 상황이라면?
	}
} //class

public class UserExceptionTest1 {
	
	public static void main(String[] args) {					//1) main 실행
		User user = new User();									
		System.out.println("2. go() calling...");				//2) 1번째 출력
		try {
			user.go();											//3) go 메소드 호출
//		}catch(ArithmeticException e) {							//8) 폭탄 catch
		}catch(ZeroDevide e) {
//			System.out.println("날라온 폭탄을 처리했습니다");	
			System.out.println(e.getMessage());	
//			e.printStackTrace();								//개발시에는 써도 되지만 배포시에는 x - 해커들 표적
		}
																
		System.out.println("3.프로그램을 종료합니다..");				//9) 3번째 출력 - 정상 종료
		

	} //main

} //
