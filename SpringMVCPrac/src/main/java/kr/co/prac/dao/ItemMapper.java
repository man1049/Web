package kr.co.prac.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.prac.domain.ItemVO;

public interface ItemMapper {
	
	@Select("select * from item")
	public List<ItemVO> selectAll();
	
	@Select("select * from item where item_num = #{item_num}")
	public ItemVO selectOne(int item_num);
	
}
