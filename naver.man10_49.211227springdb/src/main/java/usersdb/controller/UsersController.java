package usersdb.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import usersdb.domain.Users;
import usersdb.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	public void insertUsers() {
		if(usersService.insertUsers() == true) {
			System.out.println("삽입성공");
		}else {
			System.out.println("삽입실패");
		}
	}
	
	public void selectAll() {
		List<Users> users = usersService.selectAll();
		if(users != null) {
			for(Users user : users) {
				System.out.println(user.toString());
			}
		}
		
	}
	public void selectOne(int num) {
		Users user = usersService.selectOne(num);
		if(user != null) {
			System.out.println(user.toString());
		}else {
			System.out.println("정보가 없습니다.");
		}
	}
	public void updateUsers(int num, String id, String pw, String name, Timestamp birthday) {
		Users users = new Users();
		users.setNum(num);
		users.setId(id);
		users.setPw(pw);
		users.setName(name);
		users.setBirthday(birthday);
		
		usersService.updateUsers(users);
		
	}
	
	public void deleteUsers(int num) {
		int res = usersService.deleteUsers(num);
		System.out.println(res);
		if(res > 0) {
			System.out.println(num+" : 삭제 완료");
		}else {
			System.out.println("해당 정보가 없습니다");
		}
	}
	
}
