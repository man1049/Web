package usersdb.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import usersdb.domain.Users;

public class UsersDao {
	
	@Autowired
	//XML을 이용하는 MyBatis 사용 객체
	private SqlSession sqlSession;
	
	//데이터 삽입을 위한 메서드
	public int insertUsers(Users users) {
		//uesrs namespace의 insertusers라는 id를 가진 sql을 실행하는데
		//파라미터로 users를 대입
		return sqlSession.insert("users.insertusers", users);
		
	}
	
	public int maxNum() {
		return sqlSession.selectOne("users.maxnum");
	}
	
	public List<Users> selectAll() {
		 return sqlSession.selectList("selectall");
	}
	
	public Users selectOne(int num) {
		//조회되는 데이터가 없거나 1개인 경우 사용
		//데이터가 없으면 null을 리턴하고 1개인 경우는 resultType 1개리턴
		//2개 이상이면 예외 발생
		return sqlSession.selectOne("selectone",num);
	}
	
	public int updateUsers(Users users) {
		return sqlSession.update("updateusers", users);
	}
	public int deleteUsers(int num) {
		return sqlSession.delete("deleteusers", num);
	}
}
