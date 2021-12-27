package spring1224database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import usersdb.controller.UsersController;


public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		/*
		//UsersController 클래스의 인스턴스 가져오기
		UsersController us = context.getBean(UsersController.class);
		
		//메서드 호출
		us.getList();
		*/
		
		SqlSessionFactory sqlsessionfactory = context.getBean("sqlSessionFactor",SqlSessionFactory.class);
		System.out.print(sqlsessionfactory);
		
		context.close();
	}

}
