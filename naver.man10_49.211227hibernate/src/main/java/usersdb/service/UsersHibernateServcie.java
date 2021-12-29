package usersdb.service;

import java.sql.Timestamp;

import usersdb.domain.Users;

public interface UsersHibernateServcie {
	public void insertUsers(int num,String id,String pw,String name,Timestamp birthday);
	public void deleteUsers(int num);
	public void selectAllHUsers();
	public void selectOneHUsers(int num);
}
