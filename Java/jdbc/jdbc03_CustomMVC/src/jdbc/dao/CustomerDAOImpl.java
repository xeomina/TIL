package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import jdbc.vo.Customer;
/*
 * DAO 실체 클래스
 * 클라이언트 요청에 해당하는 비즈니스 로직들이 정의되어져 있는 DAO 클래스
 * VO와 함께 이런 클래스들을 model이라 부른다
 * 
 * 아무리 클라이언트의 요청이 많더라도
 * 서버상에서 오직 하나의 인스턴스만 생성되어지도록 싱글톤 패턴으로 작성
 * 
 */
public class CustomerDAOImpl implements CustomerDAO {
	//SingleTone Pattern - dao 
	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	private CustomerDAOImpl() {
		System.out.println("DAO Imple Creating...");
	}
	public static CustomerDAOImpl getInstance() {
		return dao;
	}
	

	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASS);
		System.out.println("DB Server Connect...");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		closeAll(ps,conn);	
	}
	
	//Business Logic
	@Override
	public void registerCustomer(Customer vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	

		try {
			conn = getConnect();		
			
			String query = "INSERT INTO custom (num, name, addr) VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			
//			int num = vo.getNum();
//			String name = vo.getName();
//			String addr = vo.getAddr();
//			
//			ps.setInt(1, num);
//			ps.setString(2, name);
//			ps.setString(3, addr);
			
			ps.setInt(1, vo.getNum());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getAddr());
			
			ps.executeUpdate();		//DB 서버의 테이블로 값이 주입됨
			System.out.println(vo.getName()+"님, 회원가입 되셨습니다.");
			
		}finally {
			closeAll(ps,conn);			
		}
	}//registerCustomer

	@Override
	public void deleteCustomer(int num) throws SQLException {
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
	}//deleteCustomer

	@Override
	public void updateCustomer(Customer vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	

		try {
			conn = getConnect();		
			
			String query = "UPDATE custom SET name = ?, addr = ? WHERE num = ?";
			ps = conn.prepareStatement(query);
			
//			int num = vo.getNum();
//			String name = vo.getName();
//			String addr = vo.getAddr();
//			
//			ps.setString(1, name);	
//			ps.setString(2, addr);
//			ps.setInt(3, num);
			
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getAddr());
			ps.setInt(3, vo.getNum());
			
			ps.executeUpdate();
			System.out.println(vo.getName()+"님의 정보가 수정되었습니다.");
			
			
		}finally {
			closeAll(ps,conn);			
		}
		
	}//updateCustomer

	@Override
	public Customer getCustomer(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		Customer c = new Customer();
		Customer c = null;				//생성 대신 선언
		
		try {
			conn=getConnect();
			
			String query = "SELECT * FROM custom WHERE num = ?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, num);
			
			rs = ps.executeQuery();
			
//			while(rs.next()) {
//				c.setNum(rs.getInt("num"));
//				c.setName(rs.getString("name"));
//				c.setAddr(rs.getString("addr"));
//			}
			
			if(rs.next()) {						//while 대신 if로 - 데이터가 있다면
				c = new Customer(num,
						rs.getString("name"),
						rs.getString("addr"));	//데이터 pack해서 객체로 만들어야 함
				
			}

		}finally {
			closeAll(rs, ps, conn);
		}
		return c;
	}//getCustomer

	@Override
	public ArrayList<Customer> getAllCustomer() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Customer> custs = new ArrayList<Customer>();		//list는 생성까지 해야!

		try {
			conn=getConnect();
			
			String query = "SELECT * FROM custom";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
//			while(rs.next()) {
//				int num = rs.getInt("num");
//				String name = rs.getString("name");
//				String addr = rs.getString("addr");
//				Customer c = new Customer(num,name,addr);
//				custs.add(c);
				
			while(rs.next()) {
				custs.add(new Customer(rs.getInt("num"),
						rs.getString("name"),
						rs.getString("addr")));

			}

		}finally {
			closeAll(rs, ps, conn);
		}
		return custs;
	}//getAllCustomer

}//class
