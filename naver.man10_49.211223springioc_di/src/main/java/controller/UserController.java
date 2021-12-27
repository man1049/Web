package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.UserService;
import serviceimpl.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	//setter가 자동으로 만들어지고 동일한 자료형의 bean이 있으면 자동 주입
	private UserService userService;
	
	public void doGet() {
		userService.getUser();
	}
}
