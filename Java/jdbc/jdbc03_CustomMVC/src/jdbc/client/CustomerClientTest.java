package jdbc.client;

import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import jdbc.dao.CustomerDAOImpl;
import jdbc.vo.Customer;

public class CustomerClientTest {
	//Static 초기화
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success...");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail...");
		}
	}//static

	public static void main(String[] args) throws SQLException {
		//싱글톤으로 하나 만들어놓은 객체를 받아서 사용
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		dao.registerCustomer(new Customer(555, "John", "Brandon"));
		dao.deleteCustomer(555);
		dao.updateCustomer(new Customer(333, "Tom", "Boston"));
		System.out.println(dao.getCustomer(111));
//		System.out.println(dao.getAllCustomer());
		ArrayList<Customer> list=dao.getAllCustomer();
		for(Customer c : list)
			System.out.println(c);


	}//main

}//class
