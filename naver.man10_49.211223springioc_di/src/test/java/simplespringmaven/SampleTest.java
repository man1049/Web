package simplespringmaven;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.UserService;

//Spring에서 사용 할 수 있는 JUnit 클래스를 위한 설정
@RunWith(SpringJUnit4ClassRunner.class)
//설정 파일 이용을 위한 코드
//src/main/resources 디렉토리의 것은 앞에 classpath: 를 붙여야 합니다.
@ContextConfiguration("classpath:applicationContext.xml")
public class SampleTest {
	@Autowired
	private UserService userService;
	
	//테스트용 메서드를 만들기 위한 어노테이션
	@Test
	public void method() {
		userService.getUser();
	}
	
}
