package Sub;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

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
	
	// JSON
	@Override
	public void getList(HttpServletRequest request, HttpServletResponse response) {
		int pagenum = 1;
		String num = (request.getParameter("pagenum"));
		if(num != null) {
			pagenum = Integer.parseInt(num);
		}

		//전체 데이터 개수를 가져오기
		int totalcount = dao.getCount();
		//종료 페이지 번호 계산
		int endpage = (int)(Math.ceil(pagenum/(double)5)*5);

		//데이터 개수를 가지고 나올 수 있는 페이지 개수를 계산
		//1개이면 1페이지, 5개이면 1페이지, 6개이면 2페이지
		//120 개이면 24페이지
		
		int pagecount = (int)(Math.ceil(totalcount/(double)5));
		
		//마지막 페이지 번호가 전체 페이지 마지막 번호보다 크면
		if(endpage > pagecount) {
			endpage = pagecount;
		}
		
		//DAO의 메서드를 호출
		System.out.println("//DAO의 메서드를 호출"+pagenum);
		List<Sub> list = dao.getList(pagenum);		
		
		//위의 데이터를 JSON 데이터 배열로 변환
		JSONArray ar = new JSONArray();
		for(Sub sub : list) {
			JSONObject obj = new JSONObject();
			obj.put("code", sub.getCode());
			obj.put("category", sub.getCategory());
			obj.put("description", sub.getDescription());
			obj.put("title", sub.getTitle());
			
			ar.put(obj);
		}
		
		//하나의 JSON 객체로 데이터 배열, 현재 페이지 번호, 전체 페이지 개수를 저장
		
		JSONObject obj = new JSONObject();
		
		//출력 할 데이터
		obj.put("ar", ar);
		//현재까지 출력 한 페이지 번호
		obj.put("pagenum", pagenum);
		//전체 페이지 개수
		obj.put("endpage", endpage);
		
		request.setAttribute("res", obj);
		
		
	}
/*
	@Override
	public void getList(HttpServletRequest request, HttpServletResponse response) {
		//파라미터를 읽기
		String num = request.getParameter("pagenum");
		int pagenum = 1;
		
		if(num != null) {
			pagenum = Integer.parseInt(num);
		}
		List<Sub> list = dao.getList(pagenum);
		
		//전체 데이터 개수를 가져오기
		int totalcount = dao.getCount();
		//종료 페이지 번호 계산
		int endpage = (int)(Math.ceil(pagenum/(double)5)*5);
		//시작 페이지 번호 계산
		int startpage = endpage - 4;
		
		//데이터 개수를 가지고 나올 수 있는 페이지 개수를 계산
		//1개이면 1페이지, 5개이면 1페이지, 6개이면 2페이지
		//120 개이면 24페이지
		
		int pagecount = (int)(Math.ceil(totalcount/(double)5));
		
		//마지막 페이지 번호가 전체 페이지 마지막 번호보다 크면
		if(endpage > pagecount) {
			endpage = pagecount;
		}
		
		//이전과 다음 페이지 존재여부
		
		boolean prev = startpage == 1 ? false : true;
		boolean next = endpage >= pagecount ? false : true;
		//DAO의 메서드를 호출
				
		
		//결과를 저장
		request.setAttribute("list", list);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("endpage", endpage);
		request.setAttribute("startpage", startpage);
		
		System.out.println(startpage);
		System.out.println(prev);
		System.out.println(next);
		System.out.println(endpage);
		
	}
*/
	@Override
	public void getInfo(HttpServletRequest request, HttpServletResponse response) {
		//"sub/info".length()
		String[] uri = request.getRequestURI().split("/");
		int code = Integer.parseInt(uri[uri.length-1]);
		
		Sub sub = dao.getInfo(code);
		
		request.setAttribute("info", sub);
	}

	@Override
	public void setInsert(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("SubServiceImpl-Insert error : "+e.getLocalizedMessage());
		}
		
		String title = request.getParameter("title");
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

	@Override
	public void setDelete(HttpServletRequest request, HttpServletResponse response) {
		String[] ar = request.getRequestURI().split("/");
		int code = Integer.parseInt(ar[ar.length-1]);
		
		//int code = request.getParameter("");
		
		dao.delete(code);
	}

	@Override
	public void setUpdate(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("SubServiceImpl-Insert error : "+e.getLocalizedMessage());
		}
		Sub sub = new Sub();
		int code = Integer.parseInt(request.getParameter("code"));
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		sub.setCode(code);
		sub.setTitle(title);
		sub.setCategory(category);
		sub.setDescription(description);
		
		int res = dao.update(sub);
		
		request.getSession().setAttribute("res", res);

	}
}
