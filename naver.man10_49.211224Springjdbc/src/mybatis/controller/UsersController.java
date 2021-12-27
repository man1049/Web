package mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mybatis.service.UserService;

//기본 패키지 안에 있는 경우 bean을 자동으로 생성해주는 annotation
//Controller는 사용자의 요청과 매핑이 되는 부분이라서
//웹 프로젝트의 경우는 Servlet으로 만들어집니다.

@Controller
public class UsersController {
	@Autowired
	private UserService userservice;


}
