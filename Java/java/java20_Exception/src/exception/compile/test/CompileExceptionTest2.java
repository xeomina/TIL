package exception.compile.test;
/*
 * finally ������ ������� �ʴ� ���
 * 1. ���θ� ������ ���ؼ� ��ǻ���� �Ŀ��� ���� ���
 * 2. finally ��� �ȿ��� �Ǵٸ� ���ܰ� �߻��� ��� - ���� !!!!
 * 	  -> ���ܸ� �ٽ� ó���ϰ� finally ����
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading2{
	public void readFile(String filename) {
		
		FileReader fr = null;								//2)�Ѵܰ� ���� local V�� ����
		
		try {
			//Stream �ڿ��� ��� ����ϰڴ� == ��ü ������ �ǹ�
//			FileReader fr = new FileReader(filename);		//1)try�� �ȿ����� ���Ǵ� local V
			fr = new FileReader(filename);					//3)���� ������ local V ���
			
			System.out.println("FileReader Creating...");
			
		} catch (FileNotFoundException e1) {
			System.out.println("������ ã�� ���߽��ϴ�");		
			
		}finally {
			//������ ��� ����� �ڿ��� finally �� �ȿ��� �ݾ��ش�.
			try {
				fr.close();	
				System.out.println("�ڿ��� �ݽ��ϴ�");			//�� �ٸ� ���� �߻�
			} catch (IOException e) {						//�ٽ� ó��
			}
		}
		System.out.println("file end...");
		
	}	//readFile
}	//class


public class CompileExceptionTest2 {
	public static void main(String[] args) {
		FileReading2 fr = new FileReading2();
		String path = "C:\\miracom_edu\\util\\message.txt";
		
		fr.readFile(path);
		System.out.println("������ �� �о�鿴���ϴ�");
		
	}	//main

}	//
