package mybatis.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class UsersVO {
	private int num;
	private String id;
	private String pw;
	private String name;
	private Date birthday;
}
