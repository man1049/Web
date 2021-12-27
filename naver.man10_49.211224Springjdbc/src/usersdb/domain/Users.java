package usersdb.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Users {
	private int num;
	private String id;
	private String pw;
	private String name;
	private Date birthday;
}
