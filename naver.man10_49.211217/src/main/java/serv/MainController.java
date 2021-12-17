package serv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//Controller는 Service를 주입받아야 함
	private MainService ms;

	public MainController() {
		super();
		ms = MainServiceImpl.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//분기문 작성
		//클라이언트의 요청 URL
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String uri = requestURI.substring(contextPath.length()+1);
		System.out.println(uri);
		String[] uri2 = requestURI.split(contextPath+"/");
		System.out.println(uri2[1]);

		switch(uri) {
		case "insert.main" :
			if(request.getMethod().equals("GET")) {
				//단순 페이지 이동은 포워딩
				RequestDispatcher rd = request.getRequestDispatcher("main/insert.jsp");
				rd.forward(request, response);
			}
			//GET 방식이 아니면 POST
			else {
				//일을 할 때는 적절한 서비스 메서드를 호출
				ms.doInsert(request, response);

				//끝나고 나면 메인 페이지로 리다이렉트
				response.sendRedirect("./");
			}
			break;
			
		case "logout.main" :
			ms.doLogout(request, response);
			
			//끝나고 나면 메인 페이지로 리다이렉트
			response.sendRedirect("main/logout.jsp");
			
			break;

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
