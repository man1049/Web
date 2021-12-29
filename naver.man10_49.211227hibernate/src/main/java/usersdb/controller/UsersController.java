package usersdb.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import usersdb.service.UsersHibernateServcie;

@Controller
public class UsersController {
	
	@Autowired
	private UsersHibernateServcie hibernateServcie;

	public void insertHUsers(int num,String id,String pw,String name,Timestamp birthday) {
		hibernateServcie.insertUsers(num, id, pw, name, birthday);
		System.out.println("하이버네이트 인서트 성공");
	}
	
	public void deleteHUsers(int num) {
		hibernateServcie.deleteUsers(num);
		System.out.println("하이버네이트 딜리트 성공");
	}
	
	public void selectAllHUsers() {
		hibernateServcie.selectAllHUsers();
	}
	
	public void selectOneHUsers(int num) {
		hibernateServcie.selectOneHUsers(num);
	}
	
}
