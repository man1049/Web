package usersdb.service;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import usersdb.dao.UsersHibernateDao;
import usersdb.domain.Users;

@Service
public class UsersHibernateServiceImpl implements UsersHibernateServcie {
	
	@Autowired
	private UsersHibernateDao usersHibernateDao;
	
	@Transactional
	public void insertUsers(int num,String id,String pw,String name,Timestamp birthday) {
		Users users = new Users();
		
		users.setNum(num);
		users.setId(id);
		users.setPw(pw);
		users.setName(name);
		users.setBirthday(birthday);
		
		usersHibernateDao.insertUsers(users);
	}
	
	@Transactional
	public void deleteUsers(int num) {
		Users users = new Users();
		users.setNum(num);
		usersHibernateDao.deleteUsers(users);
	}
	@Transactional
	public void selectAllHUsers() {
		List<Users> list = usersHibernateDao.selectAllHUsers();
		
		for(Users users : list) {
			System.out.println(users.toString());
		}
	}
	
	@Transactional
	public void selectOneHUsers(int num) {
		Users users = usersHibernateDao.selectOneHUsers(num);
		
		System.out.println(users.toString());
		
	}

}
