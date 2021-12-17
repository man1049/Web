package serv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MainService {
	//Request: 클라이언트의 요청을 확인하기 위한 객체
	//Response: 클라이언트에게 응답을 하기 위한 객체
	
	//웹에서는 모든 요청 처리 메서드의 원형을 아래처럼 만들어도 됨
	
	//데이터 삽입을 위한 메서드
	public void doInsert(HttpServletRequest request, HttpServletResponse response);
	//로그아웃을 처리하기 위한 메서드
	public void doLogout(HttpServletRequest request, HttpServletResponse response);

}
