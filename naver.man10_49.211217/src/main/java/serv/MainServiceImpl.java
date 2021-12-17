package serv;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainServiceImpl implements MainService {
	//Service는 DAO를 주입받아야 함
	
	private MainDAO mdao;
	
	//싱글톤을 위한 코드
	private MainServiceImpl() {
		mdao = MainDAO.getInstance();
		
	}
	
	private static MainService ms;
	
	static MainService getInstance() {
		
		if(ms == null) {
			ms = new MainServiceImpl();
		}	
		return ms;
	}

	@Override
	public void doInsert(HttpServletRequest request, HttpServletResponse response) {
		//파라미터 읽기
		try {
			//파라미터 인코딩 설정
			request.setCharacterEncoding("utf-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String name = request.getParameter("name");
		
		//업무 처리
		
		//DAO를 사용해야 하는 경우 DAO의 매개변수를 생성
		Map<String,Object> map = new HashMap<>();
		map.put("name", name);
		
		mdao.doInsert(map);
		
		
		
		
	}

	@Override
	public void doLogout(HttpServletRequest request, HttpServletResponse response) {
		//로그아웃은 Session을 초기화 하는 작업을 수행
		//세션 가져오기
		HttpSession hs = request.getSession();
		//세션 초기화
		hs.invalidate();
	}
	
	
}
