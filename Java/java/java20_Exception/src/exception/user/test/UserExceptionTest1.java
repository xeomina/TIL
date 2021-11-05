package exception.user.test;
/*
 * ����� ���� ����
 * User exception
 * 
 * 1. ���� ���� Exception Ŭ������ �����ؼ� ���
 * 2. � Ư���� ������ �Ǿ��� �� ���� ���������� ���ܸ� �߻���Ű�� ��
 * 	  -> ����� ���� Exception�� �ϳ��� ������ ������� ���ȴ�
 * 
 */

//�ش� Ŭ������ Exception���� ������� ��� ����?
class ZeroDevide extends Exception{			//Exception ���
   ZeroDevide(){
	   this("This is ZeroDevide Exception");
	   }
   ZeroDevide(String message){				//������ �����ε�
	      super(message);
	   }

	
} //class

class User{
	//
//	public void go() throws ArithmeticException{				//4) go ���� 
	public void go() throws ZeroDevide{				
		//��ĳ�ʷ� i,j���� ��������� �Է¹޴� ��Ȳ
		int i=10; int j=0;										//5) �����Ҵ�
		System.out.println("1. i,j�� �Էµ� ������ ������ �����մϴ�...");	//6) 2��° ���
		if(j==0) {												//7) true
			//ArithmeticException�� �߹߽��Ѿ� �Ѵ�
//			throw new ArithmeticException();					//8) ��ź ���� -> ����
//			throw new ZeroDevide("�и� 0�̸� ����");				//����� ���� - message error
			throw new ZeroDevide();				
		}
		
		//�� �κп��� i/j (10/0) ..ArithmeticException .. �̷� ������ ����Ǵ� ��Ȳ�̶��?
	}
} //class

public class UserExceptionTest1 {
	
	public static void main(String[] args) {					//1) main ����
		User user = new User();									
		System.out.println("2. go() calling...");				//2) 1��° ���
		try {
			user.go();											//3) go �޼ҵ� ȣ��
//		}catch(ArithmeticException e) {							//8) ��ź catch
		}catch(ZeroDevide e) {
//			System.out.println("����� ��ź�� ó���߽��ϴ�");	
			System.out.println(e.getMessage());	
//			e.printStackTrace();								//���߽ÿ��� �ᵵ ������ �����ÿ��� x - ��Ŀ�� ǥ��
		}
																
		System.out.println("3.���α׷��� �����մϴ�..");				//9) 3��° ��� - ���� ����
		

	} //main

} //
