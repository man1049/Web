package kr.co.prac.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.prac.dao.ItemDAO;
import kr.co.prac.dao.ItemHibernateDAO;
import kr.co.prac.dao.ItemMapper;
import kr.co.prac.domain.ItemVO;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	//private ItemDAO itemdao;
	private ItemMapper itemdao;
	
	@Autowired
	private ItemHibernateDAO itemHibernateDAO;

	@Override
	@Transactional
	public List<ItemVO> seletAll(HttpServletRequest request, HttpServletResponse response) {
		//return itemdao.selectAll();
		return itemHibernateDAO.selectAll();
	}

	@Override
	@Transactional
	public ItemVO selectOne(int item_num) {
		//return itemdao.selectOne(item_num);
		return itemHibernateDAO.selectOne(item_num);
	}
	
}
