package jdbc.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest4 {
	DBConnectionTest4(){
		
		try {
			//1. 드라이버 로딩...Fully Qualified Class Name
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 로딩 성공....");
			
			
			//2. 디비 서버 연결
			String url = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
//			DriverManager.getConnection(url,"root","1234");							//password : 1234
			Connection conn = DriverManager.getConnection(url,"root","1234");		//Connection 객체로 리턴
			System.out.println("2. 서버 연결 성공....");
			
			//3.PreparedStatement 객체생성			
			String query = "INSERT INTO custom (num, name, addr) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("3. PreparedStatement 객체 생성....");
			
			//4.?값에 대한 바인딩 -> 쿼리문 실행 -> 1? 2? 3?
			ps.setInt(1, 222);						
			ps.setString(2, "Jane");
			ps.setString(3, "Texas");
			
//			ps.setInt(1, 333);						
//			ps.setString(2, "Tom");
//			ps.setString(3, "NY");
			
			ps.executeUpdate();
			System.out.println("4. Values Insert OK...");
			
			
			//5.SELECT
			String query2 = "SELECT * FROM custom";
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ResultSet rs = ps2.executeQuery();
			System.out.println("5. Print ResultSet....");					
			
			while(rs.next()) { 								//BOE에서 엘러먼트가 들어있는 곳으로 한단계내려간다
				int num = rs.getInt("num"); 				//컬럼명 혹은 1
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				System.out.println(num +"\t |"+name+"\t |"+addr);
			}

			
			
		//예외 처리	
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패....");
		} catch(SQLException e) {
			System.out.println("서버 연결 실패....");
		}
		
		
	}//test
	
	public static void main(String[] args) {		
		new DBConnectionTest4();
	}//main
}//class
