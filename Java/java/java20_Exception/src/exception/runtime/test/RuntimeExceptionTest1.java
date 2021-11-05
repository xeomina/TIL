package exception.runtime.test;
/*
 * Runtime Exception
 * 1. 
 * �����Ϸ��� �ν��� ����
 * �������� �ǰ� ������ �� ���ܸ� �߻���Ų��
 * 
 * 2.
 * ����ó���� ���� ��������� �� �ʿ䰡 ����
 * �ҽ��ڵ带 �����ϱ⸸ �ϸ� �ȴ�
 * 
 * 
 * ��������� ���� ó���ϴ� ���
 * try{
 * 				//���� �߻� ���ɼ� �ִ� �ڵ�
 * 				//���࿡ ���� �߻��� �ȵǸ� �� �κ��� ����
 * }catch(���� Ÿ��){
 *  			//���ܸ� ����� �� ����Ǵ� �ڵ�
 * 				//���࿡ try ������� ���ܰ� �߻��Ǹ� �� �κ����� ������
 * }finally{
 * 				//���� �߻��ϵ� ���ϵ� ������ ����Ǿ����� �ϴ� �ڵ�
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
		while(i<=3) {										//4�� �Ǹ� loop �������� 
			try {
				System.out.println(str[i]);					//i=0,1,2�϶��� ���� x, i=3�϶� ����(����) - JVM: �߻��� Ÿ������ ��ü�� (���׵� ��ü�� �ڵ鸵!) -> �ٽ� ���α׷�����
			}catch(ArrayIndexOutOfBoundsException e) {		//JVM�� ���� ��ü(ArrayIndexOutOfBoundsException)�� catch!!
				System.out.println("Nice Catch");			
			}
			i++;											//i=0->1->2->3->4
		}
		System.out.println("while loop the end");
	}
}
