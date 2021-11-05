package exception.compile.test;
/*
 * 예외처리 방법
 * 1. 명시적으로 그자리에 즉각적으로 처리
 * 	  try ~catch
 * 2. 즉각적으로 처리하지 않고 발생한 예외를 던지는 방법
 * 	  throws
 * 
 * 1,2번 둘다 쓰임
 * 예외처리하는 패턴이 존재
 * throws / catch ~try 처리
 * finally를 함께 써줘야 한다
 * catch구문에서 예외 메세지를 어떻게 출력?
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
	//readFile 메소드를 호출한 곳으로 예외가 던져진다 !!!
//	public void readFile(String filename) throws FileNotFoundException, IOException{		//여러개 던질 수 있다
	public void readFile(String filename) throws IOException{								//IOException으로 하나만 던져도 됨 - 부모
		
		//발생한 예외 객체를 던진다
		FileReader fr = null;	
		try {																				//throws는 예외 던지는데 finally 쓰기 위해 try
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
 * 둘 다 예외가 발생한 원인에 대해서 메세지를 출력하는 기능을 한다.
 *  둘 다 일반적으로
 *   catch문 안에서 사용되어지는 기능이다.
 * 
 * 
 */
public class CompileExceptionTest3 {
	//main 메소드를 호출한 곳(JVM)으로 예외가 던져진다 !!!
	public static void main(String[] args) {
		FileReading3 fr = new FileReading3();
//		String path = "C:\\miracom_edu\\util\\message.txt";
		String path = "C:\\miracom_edu\\util\\mess.txt";
		try {
			fr.readFile(path);
		} catch (FileNotFoundException e) {			
//			e.printStackTrace(); 					//자체적으로 출력
			e.getMessage();
		} catch (IOException e) {		
			System.out.println(e.getMessage()); 	//sysout안에서 출력
		}		
		System.out.println("파일을 잘 읽어들였습니다");
		
	}	//main

}	//
