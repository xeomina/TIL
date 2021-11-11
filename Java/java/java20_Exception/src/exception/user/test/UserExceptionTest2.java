package exception.user.test;

import java.util.Scanner;

class UnderAgeException extends Exception{			
	UnderAgeException(){
		   this("This is UnderAgeException");
		   }
	UnderAgeException(String message){				
		      super(message);
		   }
}//class


class AdultMovieService{
	public void entrance(int age) throws UnderAgeException {
		if(age>=19) {
			System.out.println("Ticketing...OK, Entrance");
		}else {		//���������� ���� ��ü ���� - ��ź
			throw new UnderAgeException("UnderAge!!");
		}
	}
	
}//class

public class UserExceptionTest2 {
	
	public static void main(String[] args) {	
		AdultMovieService service = new AdultMovieService();
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է�: ");
		int age = sc.nextInt();
		try {
			service.entrance(age);
		}catch(UnderAgeException e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("10�ð� �Ǿ ������ ��ȭ�� ���մϴ�.");
		}
		System.out.println("���幮�� �ݽ��ϴ�..�մԵ鲲���� �� �����ֽñ� �ٶ��ϴ�.");

	} //main

} //