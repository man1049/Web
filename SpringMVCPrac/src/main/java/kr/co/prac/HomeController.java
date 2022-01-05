package kr.co.prac;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.prac.domain.EmailReport;
import kr.co.prac.domain.ItemReport;
import kr.co.prac.domain.ItemVO;
import kr.co.prac.domain.Login;
import kr.co.prac.service.ItemService;
import kr.co.prac.validator.MemberValidator;

@Controller
public class HomeController {
	
	@Autowired
	private ItemService itemservice;
	
	@GetMapping(value = "/")
	public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
		//데이터를 저장해서 전달
		model.addAttribute("items", itemservice.seletAll(request, response));
		return "home";
	}
	@GetMapping(value = "/detail/{itemnum}")
	public String detail(Model model,@PathVariable int itemnum) {
			model.addAttribute("item", itemservice.selectOne(itemnum));
		return "detail";
	}
	
	@GetMapping(value = "/animal.xml")
	public String animals(Model model , HttpServletRequest request, HttpServletResponse response) {
		
		//데이터 가져오기
		List<ItemVO> list = itemservice.seletAll(request, response);
		//데이터 저장
		//XML 출력을 위한 어노테이션을 설정한 클래스의 인스턴스를 데이터로 지정
		model.addAttribute("list", new ItemReport(list));
		
		return "itemreport";
	}
	/*
	@GetMapping(value = "/exception")
	public String avgpage() {
		return "input";
	}
	*/
	@GetMapping(value = "/cal")
	public String avg(Model model, @RequestParam("dividend") int dividend, @RequestParam("divisor") int divisor) {
		
		model.addAttribute("res", dividend/divisor);
		
		return "res";
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public String handleException(Exception e, Model model) {
		//model.addAttribute("content", e.getLocalizedMessage());
		return "error/exception";
	}
	
	@GetMapping(value = "/message")
	public String message(@ModelAttribute("login") Login login) {
		return "loginform";
	}
	
	@PostMapping(value = "/message")
	public String message(@Valid @ModelAttribute("login") Login login,BindingResult result/*submit을 눌렀을 때*/) {
		//유효성 검사 수행
		//new MemberValidator().validate(login, result);
		//검사 결과 에러가 있으면
		if(result.hasErrors()) {
			return "loginform";
		}
		//검사 결과 에러가 없으면 리다이렉트
		return "redirect:/";
	}
	
	// 모든 결과 페이지에 loginTyeps 라는 이름의 메서드의 리턴값을 전달
	@ModelAttribute("loginTypes")
	public List<String> loginTypes(){
		List<String> list = new ArrayList<String>();
		list.add("일반회원");
		list.add("VIP");
		list.add("admin");
		return list;
	}
	
	@GetMapping(value = "fileupload")
	public String fileupload(){
		return "fileupload";
	}
	
	@PostMapping("fileuploadrequest")
	//파일 업로드를 Request를 이용해서 처리
	public String fileUpload(MultipartHttpServletRequest request) {
		
		String email = request.getParameter("email");
		MultipartFile report = request.getFile("report");
		
		System.out.println(email);
		System.out.println(report);
		
		return "redirect:/";
	}
	
	@PostMapping("fileuploadparam")
	//파일 업로드를 Request를 이용해서 처리
	public String fileUpload(@RequestParam("email") String email,@RequestParam("report") MultipartFile report) {
		
		System.out.println(email);
		System.out.println(report);
		
		return "redirect:/";
	}
	
	@PostMapping("fileuploadcommand")
	//파일 업로드를 Request를 이용해서 처리
	public String fileUpload(@ModelAttribute("emailReport") EmailReport emailReport,HttpServletRequest request) {
		
		//파일을 업로드 할 경로를 생성
		//프로젝트 내의 webapp 내의 upload 디렉토리의 절대 경로 생성
		String uploadPath = request.getServletContext().getRealPath("/upload");
		
		//파일의 원래 이름
		String filename = emailReport.getReport().getOriginalFilename();
		
		//파일명 그대로 저장
		//File filepath = new File(uploadPath + "/" + filename);
		
		//파일명에 이메일주소를 추가하여 추가
		//File filepath = new File(uploadPath + "/" + emailReport.getEmail() + filename);
		
		//랜덤한 문자열을 추가
		File filepath = new File(uploadPath + "/" + UUID.randomUUID() + filename);
		
		try {
			emailReport.getReport().transferTo(filepath);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return "redirect:/";
	}
}
