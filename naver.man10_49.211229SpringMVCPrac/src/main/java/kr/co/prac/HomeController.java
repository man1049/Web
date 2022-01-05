package kr.co.prac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;

import kr.co.prac.domain.ItemVO;
import kr.co.prac.service.ItemService;

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
}
