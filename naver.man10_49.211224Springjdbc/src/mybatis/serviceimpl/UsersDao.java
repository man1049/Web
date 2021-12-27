package mybatis.serviceimpl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.domain.UsersVO;
//기본 패키지 안에 있는 경우 bean을 자동으로 생성해주는 annotation
//Repository는 저장소와 관련 된 클래스라는 것을 명시적으로 알려주는 것 입니다.
//Component 라고 작성해도 됩니다.
@Repository
public class UsersDao {
	//동일한 자료형의 bean이 있으면 자동으로 주입해주는 annotation
	@Autowired
	private SqlSession sqlSession;
	
	public void getUsers() {
		
	}
	

}
