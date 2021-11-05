package jdbc.simple.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*
 * JDBC 프로그램을 조금 더 구조적으로 이해해보는 단계
 * 
 * Business Logic: 
 * 	중요한 로직 - DAL (Database Access Logic)
 * 	메소드 단위마다
 * 		1.Connection 리턴 - DB서버 연결
 * 		2.쿼리문 인자값으로 PreparedStatement 생성
 * 		3.바인딩
 * 		4.쿼리문 실행
 * 		5.자원 닫고
 * 	1~5번까지가 반복되어져 작성된다
 * 	1~5번 중에서 
 * 		고정적인 부분 -- 공통의 기능으로 뽑아 놓고 재사용 o -> 1,5번
 * 		   vs.
 * 		가변적인 부분 -- 공통의 기능으로 따로 작성 x -> 나머지..
 * 
 */

public class SimpleCustomTest {
	//메소드 단위마다 반복되는 기능을 정의
	public Connection getConnect() throws SQLException{
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASS);
		System.out.println("DB Server Connect...");
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	//Method Overloading : 하는 일은 큰 틀에서는 같지만 처리하는 데이터를 달리할 때 사용하는 기법
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
		if(rs != null) rs.close();
		closeAll(ps,conn);	//재사용
	}
	
	
	//DML에 해당하는 기능들을 정의 - 쿼리문을 함수로
	//INSERT --?,?,?
	public void addCustom(int num, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	//로컬 변수 초기화 - 안하면 에러
		
		try {
//			conn=DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
//			System.out.println("DB Server Connect...");
			conn = getConnect();		//메소드로 받아오기
			
			String query = "INSERT INTO custom (num, name, addr) VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, num);
			ps.setString(2, name);
			ps.setString(3, addr);
			
			ps.executeUpdate();
			System.out.println(name+"님, 회원가입 되셨습니다.");
			
		}finally {
//			ps.close();
//			conn.close();
			closeAll(ps,conn);			//메소드로 받아오기
		
			
		}
	}//addCustom
	
	//DELETE
	public void removeCustom(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn=getConnect();
			
			String query = "DELETE FROM custom WHERE num = ?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, num);
			
			ps.executeUpdate();
			
			System.out.println(num + "번 회원님이 탈퇴하셨습니다.");
			
		}finally {
			closeAll(ps, conn);
		}
		
	}
	
	//UPDATE
	public void updateCustom(int num, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn=getConnect();
			
			String query = "UPDATE custom SET name = ?, addr = ? WHERE num = ?";	//SET 뒤에는 Primary key 올 수 없음 (수정의 대상), 중간에 `,` 필수 !!
			ps = conn.prepareStatement(query);
			
			ps.setString(1, name);	//물음표 순서대로 바인딩
			ps.setString(2, addr);
			ps.setInt(3, num);
			
			ps.executeUpdate();
			
			System.out.println(name + "님의 정보가 수정되었습니다.");
			
		}finally {
			closeAll(ps, conn);
		}
		
	}
	
	//SELECTALL..SELECT..executeQuery() -> ResultSet도 패턴에서 선언해줘야 함
	//VO 클래스 정의 안했기 때문에 일단 void로 리턴
	public void printAllCustom() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT * FROM custom";	//?가 없으므로 바인딩 필요 x
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("num")+" "+rs.getString("name")+" "+rs.getString("addr"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		
	}

	public static void main(String[] args) throws Exception {
		SimpleCustomTest service = new SimpleCustomTest();
		//이 부분은 나중에 클라이언트의 화면 부분이 될 것
		
		//INSERT
//		service.addCustom(555, "John", "Brandon");
		//DELETE
//		service.removeCustom(555);
		//UPDATE
//		service.updateCustom(333, "Tom", "Brandon");
		//SELECT
		service.printAllCustom();
		

	}//main
	
	//Static Initialization -> main보다 먼저 실행
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success...");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail...");
		}
		
	}
		
}//class
