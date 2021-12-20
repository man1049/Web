package Sub;

import java.io.IOException;

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
       
    public SubController() {
        super();
        ssv = SubServiceImpl.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requesturi = request.getRequestURI();
		String conpath = request.getContextPath();
		String uri = requesturi.substring(conpath.length()+1);
		switch (uri) {
		case "sub/list":
			//필요한 서비스의 메서드를 호출
			ssv.getList(request, response);
			//결과 페이지로 이동
			RequestDispatcher dispatcher = request.getRequestDispatcher("../view/list.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "sub/info":
			ssv.getInfo(request, response);
			
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("../view/info.jsp");
			dispatcher2.forward(request, response);
			break;
		case "sub/insert":
			ssv.setInsert(request, response);
			int i = (int) request.getAttribute("res");
			if(i > 0) {
				response.sendRedirect("../index.jsp");
			}else {
				response.sendRedirect("../insert.jsp");
			}
			
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
