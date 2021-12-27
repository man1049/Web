package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import controller.UserController;

public class UserMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		UserController uc = context.getBean("userController", UserController.class);
		
		uc.doGet();
		
		context.close();
	}

}
