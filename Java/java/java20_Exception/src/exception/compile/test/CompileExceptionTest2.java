package exception.compile.test;
/*
 * finally 구문이 실행되지 않는 경우
 * 1. 원인모를 이유에 의해서 컴퓨터의 파워가 꺼진 경우
 * 2. finally 블락 안에서 또다른 예외가 발생할 경우 - 지금 !!!!
 * 	  -> 예외를 다시 처리하고 finally 수행
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading2{
	public void readFile(String filename) {
		
		FileReader fr = null;								//2)한단계 위의 local V로 선언
		
		try {
			//Stream 자원을 열어서 사용하겠다 == 객체 생성의 의미
//			FileReader fr = new FileReader(filename);		//1)try블럭 안에서만 사용되는 local V
			fr = new FileReader(filename);					//3)새로 생성한 local V 사용
			
			System.out.println("FileReader Creating...");
			
		} catch (FileNotFoundException e1) {
			System.out.println("파일을 찾지 못했습니다");		
			
		}finally {
			//위에서 열어서 사용한 자원은 finally 블럭 안에서 닫아준다.
			try {
				fr.close();	
				System.out.println("자원을 닫습니다");			//또 다른 예외 발생
			} catch (IOException e) {						//다시 처리
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
		System.out.println("파일을 잘 읽어들였습니다");
		
	}	//main

}	//
