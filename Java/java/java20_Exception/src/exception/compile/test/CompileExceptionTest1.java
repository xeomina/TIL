package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
	public void readFile(String filename) {
		//File�� �б� ���� ����� ������ �ִ� Ŭ������ ���� - FileReader
		//FileReader ��ü�� �����ϸ� ������ ���ܰ� �������� �������
		try {
			FileReader fr = new FileReader(filename);
			System.out.println("FileReader Creating...");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("������ ã�� ���߽��ϴ�");
			
			/* 
			 * 1.����ΰų�
			 * 2.e.pringStackTrade(), e.getMessage()
			 * 3.System.out.println("")
			 */
		}
		System.out.println("file end...");
	}	//readFile
}	//class


public class CompileExceptionTest1 {
	public static void main(String[] args) {
		FileReading fr = new FileReading();
		String path = "C:\\miracom_edu\\util\\message.txt";
		
		fr.readFile(path);
		System.out.println("������ �� �о�鿴���ϴ�");
		
	}

}
