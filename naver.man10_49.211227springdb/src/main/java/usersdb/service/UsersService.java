package usersdb.service;

import java.util.List;

import usersdb.domain.Users;

public interface UsersService {
	public boolean insertUsers();
	public List<Users> selectAll();
	public Users selectOne(int num);
	public int updateUsers(Users users);
	public int deleteUsers(int num);
		
}
