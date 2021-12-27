package usersdb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usersdb.domain.Users;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private JdbcTemplateDao dao;

	@Override
	public void getList() {
		
		List<Users> list = dao.getList();
		
		for(Users users : list) {
			System.out.println(users);
		}
		
	}

	
	
}
