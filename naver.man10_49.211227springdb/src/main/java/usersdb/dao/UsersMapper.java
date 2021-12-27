package usersdb.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import usersdb.domain.Users;

@Repository
public interface UsersMapper {
	//전체 데이터 가져오기
	@Select("select * from users")
	public List<Users> selectAll();
	
	@Select("select * from users where num = #{num}")
	public Users selectOne(int num);
	
	@Select("select max(num) from users")
	public int maxNum();
	
	@Select("insert into users values(#{num},#{id},#{pw},#{name},#{birthday},#{image})")
	public int insertUsers(Users users);
	
	@Update("update users set id = #{id} , pw = #{pw} , name = #{name} , birthday = #{birthday} where num = #{num}")
	public int updateUsers(Users users);
	
	@Delete("delete from users where num = ${num}")
	public int deleteUsers(int num);


}
