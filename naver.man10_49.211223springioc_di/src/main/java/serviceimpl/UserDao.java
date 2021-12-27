package serviceimpl;

import org.springframework.stereotype.Repository;

import dao.User;

@Repository
public class UserDao {

	public User getUser() {
		User user = new User();
		user.setId("man10_49");
		user.setPw("man");
		return user;
	}
}
