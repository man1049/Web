package usersdb.serviceimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import usersdb.domain.Users;

//Bean을 자동으로 생성해주는 annotation
@Repository
public class JdbcTemplateDao {
	//데이터베이스 연동 클래스
	//동일한 자료형의 Bean이 있을 때 자동으로 주입해주는 annotation
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//테이블의 전체 데이터를 읽어서 리턴하는 메서드
	public List<Users> getList(){
		return jdbcTemplate.query("select * from users order by num desc", new RowMapper<Users>() {

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users users = new Users();
				
				users.setNum(rs.getInt("num"));
				users.setName(rs.getString("name"));
				users.setPw(rs.getString("pw"));
				users.setId(rs.getString("id"));
				users.setBirthday(rs.getDate("birthday"));
				return users;
			}
		});
	}
}
