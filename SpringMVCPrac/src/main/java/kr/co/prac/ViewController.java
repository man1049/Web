package kr.co.prac;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.prac.dao.ItemDAO;
import kr.co.prac.domain.ItemVO;
import kr.co.prac.service.ItemService;
import kr.co.prac.service.ItemServiceImpl;
import kr.co.prac.service.ViewService;
import kr.co.prac.service.ViewServiceImpl;

@Controller
public class ViewController {
	
	@Autowired
	private ViewService viewService;
	
	@GetMapping(value = "/fileview")
	public String fileview(Model model, HttpServletRequest request, HttpServletResponse response) {
		//서비스의 메서드 호출
		List<String> list = viewService.fileview(request, response);
		//데이터 저장
		model.addAttribute("list",list);
		
		return "fileview";
	}
	
	//download 요청처리
	@GetMapping(value = "/download")
	public String download(@RequestParam("file") String filename, Model model, HttpServletRequest request) {
		//View에게 전달 할 데이터 생성 - 실제 파일
		File file = new File(request.getServletContext().getRealPath("/picture")+"\\"+filename);
		
		//모델에 저장
		model.addAttribute("download", file);
		
		return null;
	}
	@Autowired
	private ItemService itemService;
	
	@GetMapping(value = "/animal_info.xls")
	public String animal_info(Model model ,HttpServletRequest request, HttpServletResponse response) {
		//출력 할 데이터 생성
		List<ItemVO> list = itemService.seletAll(request, response);
		model.addAttribute("list", list);
		
		return "animal_info";
	}
	
	@RequestMapping(value = "/excelread")
	public String excelread(Model model, HttpServletRequest request, HttpServletResponse response) {
		//서비스 메서드 호출
		List<Map<String,Object>> list = viewService.excelread(request, response);
		model.addAttribute("list",list);
		
		return "excelread";
	}
	
	@GetMapping(value = "/item.pdf")
	public String pdf(Model model, HttpServletRequest request, HttpServletResponse response) {
		//출력 할 데이터를 가져옴
		List<ItemVO> list = itemService.seletAll(request, response);
		//데이터 저장
		model.addAttribute("list", list);
		//출력 할 뷰 이름 결정
		return "pdf";
	}
	
	@GetMapping(value = "/item.json")
	public String json(Model model, HttpServletRequest request, HttpServletResponse response) {
		//출력 할 데이터를 가져옴
		List<ItemVO> list = itemService.seletAll(request, response);
		//데이터 저장
		model.addAttribute("list",list);
		//출력 할 뷰 이름 결정
		return "json";
	}
	
}
