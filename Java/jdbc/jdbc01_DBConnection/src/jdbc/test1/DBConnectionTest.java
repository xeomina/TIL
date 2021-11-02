package jdbc.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * JDBC 4단계작업
 * 1. 드라이버 로딩
 * 2. DB 서버 연결
 * 3. PreparedStatement 객체 생성
 * 4. 쿼리문 실행
 */

public class DBConnectionTest {
	DBConnectionTest(){
		
		try {
			//1. 드라이버 로딩...Fully Qualified Class Name
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 로딩 성공....");
			
			
			//2. DB 서버 연결
			String url = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
//			DriverManager.getConnection(url,"root","1234");							//password : 1234
			Connection conn = DriverManager.getConnection(url,"root","1234");		//Connection 객체로 리턴
			System.out.println("2. 서버 연결 성공....");
			
			//3.PreparedStatement 객체생성
			String query = "INSERT INTO custom (num, name, addr) VALUES(?,?,?)";	//뭐 넣을지 아직 몰라 -?
			PreparedStatement ps = conn.prepareStatement(query);					//쿼리문을 변수로 처리
			System.out.println("3. PreparedStatement 객체 생성....");
			
			//4.?값에 대한 바인딩 -> 쿼리문 실행 -> 1? 2? 3?
//			ps.setInt(1, 111);						//DB(custom)에 없는 값을 넣어야 함 - 에러
			ps.setInt(1, 222);						
			ps.setString(2, "Kate");
			ps.setString(3, "Boston");
			
			ps.executeUpdate();
			System.out.println("4. 쿼리문 실행....");
				
		//예외 처리	
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패....");
		} catch(SQLException e) {
			System.out.println("서버 연결 실패....");
		}
		
		
	}//test
	
	public static void main(String[] args) {		
		new DBConnectionTest();
	}//main
}//class
