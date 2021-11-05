package exception.compile.test;
/*
 * ����ó�� ���
 * 1. ��������� ���ڸ��� �ﰢ������ ó��
 * 	  try ~catch
 * 2. �ﰢ������ ó������ �ʰ� �߻��� ���ܸ� ������ ���
 * 	  throws
 * 
 * 1,2�� �Ѵ� ����
 * ����ó���ϴ� ������ ����
 * throws / catch ~try ó��
 * finally�� �Բ� ����� �Ѵ�
 * catch�������� ���� �޼����� ��� ���?
 * 
 *                     IOException
 *           			   |
 *                FileNotFoundException
 * 			
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading3{
	//readFile �޼ҵ带 ȣ���� ������ ���ܰ� �������� !!!
//	public void readFile(String filename) throws FileNotFoundException, IOException{		//������ ���� �� �ִ�
	public void readFile(String filename) throws IOException{								//IOException���� �ϳ��� ������ �� - �θ�
		
		//�߻��� ���� ��ü�� ������
		FileReader fr = null;	
		try {																				//throws�� ���� �����µ� finally ���� ���� try
			fr = new FileReader(filename);		//FileNotFoundException			
		
			System.out.println("FileReader Creating...");
			System.out.println("file end...");			
		}finally {
			fr.close();							//IOException
		}
	}	//readFile
}	//class

/*
 * printStackTrace()
 * getMessage()
 * �� �� ���ܰ� �߻��� ���ο� ���ؼ� �޼����� ����ϴ� ����� �Ѵ�.
 *  �� �� �Ϲ�������
 *   catch�� �ȿ��� ���Ǿ����� ����̴�.
 * 
 * 
 */
public class CompileExceptionTest3 {
	//main �޼ҵ带 ȣ���� ��(JVM)���� ���ܰ� �������� !!!
	public static void main(String[] args) {
		FileReading3 fr = new FileReading3();
//		String path = "C:\\miracom_edu\\util\\message.txt";
		String path = "C:\\miracom_edu\\util\\mess.txt";
		try {
			fr.readFile(path);
		} catch (FileNotFoundException e) {			
//			e.printStackTrace(); 					//��ü������ ���
			e.getMessage();
		} catch (IOException e) {		
			System.out.println(e.getMessage()); 	//sysout�ȿ��� ���
		}		
		System.out.println("������ �� �о�鿴���ϴ�");
		
	}	//main

}	//
