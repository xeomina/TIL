package jdbc.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionTest3 {
	DBConnectionTest3(){
		
		try {
			//1. 드라이버 로딩...Fully Qualified Class Name
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 로딩 성공....");
			
			
			//2. DB 서버 연결
			String url = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
//			DriverManager.getConnection(url,"root","1234");							//password : 1234
			Connection conn = DriverManager.getConnection(url,"root","1234");		//Connection 객체로 리턴
			System.out.println("2. 서버 연결 성공....");
						
			//3.DELETE		
			String query = "DELETE FROM custom WHERE num=?";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("3. PreparedStatement 객체 생성....");

			ps.setInt(1,222);
			
			int row = ps.executeUpdate();
			System.out.println("4. row Delete OK...("+row+")");
			
		//예외 처리	
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패....");
		} catch(SQLException e) {
			System.out.println("서버 연결 실패....");
		}
		
		
	}//test
	
	public static void main(String[] args) {		
		new DBConnectionTest3();
	}//main
}//class
