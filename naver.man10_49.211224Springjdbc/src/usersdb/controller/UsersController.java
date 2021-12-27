package usersdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import usersdb.serviceimpl.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService us;
	
	public void getList() {
		us.getList();
	}
	
}
