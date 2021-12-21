package Sub;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sub/*")
public class SubController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SubService ssv;
	
	private static int code_check;

	public SubController() {
		super();
		ssv = SubServiceImpl.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requesturi = request.getRequestURI();
		String conpath = request.getContextPath();
		String uri = requesturi.substring(conpath.length()+1);
		RequestDispatcher dispatcher = null;
		if(uri.indexOf("sub/info") >= 0) {
			ssv.getInfo(request, response);

			dispatcher = request.getRequestDispatcher("../../view/info.jsp");
			dispatcher.forward(request, response);
		}else if(uri.equals("sub/list")) {
			//필요한 서비스의 메서드를 호출
			ssv.getList(request, response);
			//결과 페이지로 이동
			dispatcher = request.getRequestDispatcher("../view/list.jsp");
			dispatcher.forward(request, response);
		}else if(uri.equals("sub/insert")) {
			int i = 0;
			ssv.setInsert(request, response);
			i = (int) request.getSession().getAttribute("res");

			if(i > 0) {
				request.getSession().removeAttribute("res");
				response.sendRedirect("list");
			}else {
				request.getSession().removeAttribute("res");
				dispatcher = request.getRequestDispatcher("../../insert.jsp");
				dispatcher.forward(request, response);
			}
		}else if(uri.indexOf("sub/delete") >= 0) {
			ssv.setDelete(request, response);

			response.sendRedirect("../list");
		}else if(uri.equals("sub/insertpage")) {
			dispatcher = request.getRequestDispatcher("../insert.jsp");
			dispatcher.forward(request, response);
		}else if(uri.indexOf("sub/update") >= 0) {
			//수정을 GET 방식으로 요청하면 데이터를 수정 할 수 있도록 출력
			if(request.getMethod().equals("GET")) {
			String[] ar = uri.split("/");
			code_check = Integer.parseInt(ar[ar.length-1]);
			ssv.getInfo(request, response);
			
			dispatcher = request.getRequestDispatcher("../../update.jsp");
			dispatcher.forward(request, response);

			} 
			//수정을 POST방식으로 요청하면 실제 데이터 수정
			
			else if(request.getMethod().equals("POST")) {
				if(code_check == (Integer.parseInt(request.getParameter("code")))) {
					ssv.setUpdate(request, response);
					int i = (int) request.getSession().getAttribute("res");
					
					if(i>0) {
						request.getSession().removeAttribute("res");
						response.sendRedirect("../../sub/list");
						//response.sendRedirect("../../sub/info/"+request.getParameter("code"));
					}else {
						dispatcher = request.getRequestDispatcher("../../update.jsp?code='"
					+request.getParameter("info.code")+"' title='"+request.getParameter("info.title")+"' ctegory='"+request.getParameter("info.category")+"' description='"+request.getParameter("info.description")+"'");
						dispatcher.forward(request, response);
					}
				}else {
					response.sendRedirect("../list/");
				}
				
			}
		}
		//json 출력을 위한 처리
		else if(uri.equals("sub/sclist")) {
			ssv.getList(request, response);
			
			//json 출력페이지로 포워딩
			dispatcher = request.getRequestDispatcher("../view/sclist.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
