package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.vo.Customer;

/*
 * 비즈니스 로직의 Template
 */
public interface CustomerDAO {
	//반복되는 기능 정의
	Connection getConnect() throws SQLException;	//public abstract 생략
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	//DML 기능 정의
	void registerCustomer(Customer vo) throws SQLException;		//Customer 객체단위로 코드작성
	void deleteCustomer(int num) throws SQLException;
	void updateCustomer(Customer vo) throws SQLException;
	
	Customer getCustomer(int num)throws SQLException;
	ArrayList<Customer> getAllCustomer()throws SQLException;
	


}
