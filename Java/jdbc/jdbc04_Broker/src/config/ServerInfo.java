package config;
/*
 * 인터페이스는 상수와 추상메소드로만 구성되어져 있다
 * 이런 점을 이용해서 상수값을 담아두도록 한다
 */

public interface ServerInfo {
	//인터페이스 앞에 선언된 변수는 무조건 public static final이 붙는다 -> 필드가 없기 때문에 무조건 상수 취급
	//변수앞에 무조건 public static final이 지정된다
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String USER = "root";
	String PASS = "1234";

}
