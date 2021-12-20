package Sub;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubServiceImpl implements SubService {
	//Service는 DAO를 주입받아서 사용합니다.
	private SubDAO dao;
	
	private SubServiceImpl() {
		dao = SubDAO.getInstance();
	}
	
	private static SubService ssv;
	
	public static SubService getInstance() {
		if(ssv == null) {
			ssv = new SubServiceImpl();
		}
		return ssv;
	}

	@Override
	public void getList(HttpServletRequest request, HttpServletResponse response) {
		//파라미터를 읽기
		
		//처리
		
		//DAO의 메서드를 호출
		List<Sub> list = dao.getList();
		//처리
		
		//결과를 저장
		request.setAttribute("list", list);
		
	}

	@Override
	public void getInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("SubService : "+e.getLocalizedMessage());
		}
		int code = Integer.parseInt(request.getParameter("code"));
		
		Sub sub = dao.getInfo(code);
		
		request.setAttribute("info", sub);
	}

	@Override
	public void setInsert(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("SubServiceImpl-Insert error : "+e.getLocalizedMessage());
		}
		
		String title = (String) request.getParameter("title");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		//처리
		//코드 만들기
		int code = dao.maxCode()+1;
		
		//삽입을 위한 데이터를 만들기
		Sub sub = new Sub();
		sub.setCode(code);
		sub.setTitle(title);
		sub.setCategory(category);
		sub.setDescription(description);
		
		//DAO의 메서드 호출
		int res = dao.insert(sub);
		
		//처리
		
		//결과를 저장 - 데이터 삽입이어서 리다이렉트 하므로 세션에 저장
		//어떻게 이동 할 것인지 결정
		request.getSession().setAttribute("res", res);
		
		
	}
}
