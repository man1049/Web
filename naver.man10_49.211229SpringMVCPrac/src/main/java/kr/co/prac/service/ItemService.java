package kr.co.prac.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.prac.domain.ItemVO;

public interface ItemService {
	public List<ItemVO> seletAll(HttpServletRequest request, HttpServletResponse response);
	//Servcie에서 파라미터를 읽는경우 int 대신 HttpServletRequest
	public ItemVO selectOne(int item_num);
}
