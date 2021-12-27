package usersdb.service;

import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usersdb.dao.UsersDao;
import usersdb.dao.UsersMapper;
import usersdb.domain.Users;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	//private UsersDao usersdao;
	private UsersMapper usersdao;

	public boolean insertUsers() {
		boolean res = false;
		Users users = new Users();
		
		//users.setNum(4);
		users.setNum(usersdao.maxNum()+1);
		users.setId("man_man"+(usersdao.maxNum()+1));
		users.setPw("1313");
		users.setName("아무개");
		
		GregorianCalendar cal = new GregorianCalendar();
		users.setBirthday(new Timestamp(cal.getTimeInMillis()));
		
		try {
			FileInputStream fis = new FileInputStream("c:\\images.jpg");
			byte [] image = new byte[fis.available()];
			fis.read(image);
			users.setImage(image);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resint = usersdao.insertUsers(users);
		if(resint > 0) {
			res = true;
		}
		return res;
	}

	public List<Users> selectAll() {
		List<Users> all = usersdao.selectAll();
		
		if(all.size()>0) {
			return all;
		}
		return null;
	}

	public Users selectOne(int num) {
		Users user = usersdao.selectOne(num);
		return user;
	}
	
	public int updateUsers(Users users) {
		return usersdao.updateUsers(users);
	}

	public int deleteUsers(int num) {
		int res = usersdao.deleteUsers(num);
		return res;
	}



}
