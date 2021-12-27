package springdb;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import usersdb.controller.UsersController;

public class TestMain {
	@Test
	public void tests() throws Exception{
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");

		DataSource ds = context.getBean("dataSource", DataSource.class);
		Connection con = ds.getConnection();
		//SqlSession session = context.getBean("sqlSession", SqlSession.class);
		
		UsersController usersController = context.getBean("usersController",UsersController.class);
		//usersController.insertUsers();
		//usersController.selectAll();
		usersController.selectOne(6);
		
		//GregorianCalendar cal = new GregorianCalendar();
		//usersController.updateUsers(1, "maod","5148924qq", "어기여차", new Timestamp(cal.getTimeInMillis()));
		//usersController.deleteUsers(7);
		
		
		
		
		
		
		con.close();
		context.close();



	}
}
