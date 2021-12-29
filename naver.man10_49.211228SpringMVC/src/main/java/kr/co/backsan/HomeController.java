package kr.co.backsan;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.backsan.domain.User;

//빈이 자동 생성
@Controller
public class HomeController {
	
	// /로 요청이 GET 방식으로 오면 호출되는 메서드
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//문자열을 리턴하면 이름이 뷰 이름이되고 기본적으로 포워딩 됨
	// /요청이 오면 home으로 포워딩
	// home으로 포워딩 할 때 ViewResolver 설정에 의해서
	// WEB-INT/views/home.jsp 파일로 포워딩 함
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String param() {
		return "param";
	}
	
	/*
	@RequestMapping(value = "/paramres", method = RequestMethod.POST)
	public void paramres(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String mail = request.getParameter("mail");
		String gend = request.getParameter("gend");
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(mail);
		System.out.println(gend);
	}
	*/
	/*
	@RequestMapping(value = "/paramres", method = RequestMethod.POST)
	public void paramres(@RequestParam("id") String id,@RequestParam("pw") String pw, @RequestParam("mail") String mail, @RequestParam("gend") String gend) {
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(mail);
		System.out.println(gend);
	}
	*/
	//Comand 객체를 이용하는 방법
	/*
	@RequestMapping(value = "/paramres", method = RequestMethod.POST)
	public void param(User user) {
		System.out.println(user);
	}
	*/
	//detail 요청의 가장 마지막 부분을 num에 대입
	@RequestMapping(value = "/detail/{num}", method = RequestMethod.GET)
	//위의 num을 @PathVariable의 num에 대입
	public void detail(@PathVariable int num) {
		System.out.println(num);
	}
	
	//모든 요청처리 결과에 전달하는 데이터를 생성해주는 메서드
	@ModelAttribute("user")
	@RequestMapping(value = "/paramres", method = RequestMethod.POST)
	public User paramres(User user) {
		return user;
	}
	
	@GetMapping(value = "/forward")
	public String forward(Model model) {
		//request.setAttribute("",데이터)와 동일함
		model.addAttribute("id", "아이디");

		return "result";
	}
	
	@GetMapping(value = "/redirect")
	public String redirect(Model model , HttpSession session, RedirectAttributes attributes) {
		//redirect의 경우는 이 문장은 아무런 의미가 없음
		//이렇게 작성하면 request에 저장되는데 redirect 하면 request는 다시 생성됨
		//model.addAttribute("id", "아이디");
		
		//이 경우는 session을 초기화하거나 data를 삭제하지 않는 한 계속 유지
		session.setAttribute("id", "아이디");
		
		//이 경우는 세션에 저장했다가 한번 redirect 하고 나면 자동 소멸
		attributes.addFlashAttribute("id", "아이디");
		
		
		//여기서 result는 Controller 에게 돌아오기 위한 URL 이어야 함
		//어딘가에 result를 처리해주는 메서드가 있어야 함
		//데이터에 변화가 생기면 특별한 경우가 아니고는 redirect
		return "redirect:forward";
	}
	
	
}
