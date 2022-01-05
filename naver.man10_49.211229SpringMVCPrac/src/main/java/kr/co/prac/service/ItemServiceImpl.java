package kr.co.prac.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.prac.dao.ItemDAO;
import kr.co.prac.domain.ItemVO;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDAO itemdao;

	@Override
	public List<ItemVO> seletAll(HttpServletRequest request, HttpServletResponse response) {
		return itemdao.selectAll();
	}

	@Override
	public ItemVO selectOne(int item_num) {
		return itemdao.selectOne(item_num);
	}
	
}
