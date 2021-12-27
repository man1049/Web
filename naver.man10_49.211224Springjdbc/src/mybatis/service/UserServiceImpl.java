package mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.domain.UsersVO;
import mybatis.serviceimpl.UsersDao;

//기본 패키지 안에 있는 경우 bean을 자동으로 생성해주는 annotation
//Service는 사용자의 요구사항을 처리하는 코드와 관련 된 클래스라는 것을 명시적으로 알려주는 것 입니다.
//Component 라고 작성해도 됩니다.

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UsersDao usersdao;
}
