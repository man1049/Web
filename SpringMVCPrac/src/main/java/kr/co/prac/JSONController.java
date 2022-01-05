package kr.co.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.prac.domain.ItemVO;
import kr.co.prac.service.ItemService;

@RestController
public class JSONController {
	@Autowired
	private ItemService itemService;
	
	@GetMapping(value = "/item.csv")
	public String itemcsv() {
		return "csv,xml,json";
	}
	
	@GetMapping(value = "/itemrest.json")
	public List<ItemVO> item(HttpServletRequest request, HttpServletResponse response) {
		/*
		ItemVO item = new ItemVO();
		item.setItem_num(1);
		return item;
		*/
		List<ItemVO> list = itemService.seletAll(request, response);
		
		return list;
		
	}
	
	
}
