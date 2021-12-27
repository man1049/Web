package usersdb.domain;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class Users {
	private int num;
	private String id;
	private String pw;
	private String name;
	private Timestamp birthday;
	private byte[] image;
}
