package filter;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import wrapper.MainRequestWrapper;

@WebFilter("*.main")
public class MainFilter implements Filter {

    public MainFilter() {
    }

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Controller에게 가기 전에 호출");
		
		
		MainRequestWrapper mrw = new MainRequestWrapper((HttpServletRequest) request);
		
		chain.doFilter(mrw, response);
		
		//현재시간 불러오기
		Date date = new Date(System.currentTimeMillis());
		
		//날짜로 만들기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		
		//파일 이름
		String filename = sdf.format(date)+".log";
		
		//접속 한 아이피 찾기
		String ip = request.getRemoteAddr();

		//요청 찾아오기
		HttpServletRequest hsr = (HttpServletRequest) request;
		String requestURI = hsr.getRequestURI();
		
		FileOutputStream fos = new FileOutputStream(filename, true);
		PrintWriter pw = new PrintWriter(fos);
		System.out.println("생성완료");
		
		sdf = new SimpleDateFormat("hh:mm:ss");
		pw.println(sdf.format(date)+"/"+request.getParameter("name")+"/"+ip+"/"+requestURI);
		pw.flush();
		fos.flush();
		pw.close();
		fos.close();
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	


}
