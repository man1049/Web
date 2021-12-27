package spring1224database;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class ConnectionTest {
	//데이터베이스 접속에 필요한 4가지 정보
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://118.32.35.166:3306/211224springdb?characterEncoding=UTF-8&serverTimezone=UTC";
	static String user = "project_member";
	static String pw = "pH6*qRE[zZ";
	
	
	@Test
	public void testConnection() {
		//드라이버 클래스 로드
		try {
			Class.forName(driver);
		}catch(Exception e) {System.out.println(e.getLocalizedMessage());}

		// 데이터베이스 연결 객체 생성
		try{
			Connection con = DriverManager.getConnection(url,user,pw);
		}catch(Exception e2){System.out.println(e2.getLocalizedMessage());}
	}
}

