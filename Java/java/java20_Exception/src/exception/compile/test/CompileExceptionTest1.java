package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
	public void readFile(String filename) {
		//File을 읽기 위한 기능을 가지고 있는 클래스를 제공 - FileReader
		//FileReader 객체를 생성하면 무조건 예외가 터지도록 만들었다
		try {
			FileReader fr = new FileReader(filename);
			System.out.println("FileReader Creating...");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("파일을 찾지 못했습니다");
			
			/* 
			 * 1.비워두거나
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
		System.out.println("파일을 잘 읽어들였습니다");
		
	}

}
