package kr.co.prac.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.prac.domain.ItemVO;

@Repository
public class ItemDAO {
	//데이터베이스 프레임워크의 인스턴스를 주입받아야함
	@Autowired
	private SqlSession session;
	
	public List<ItemVO> selectAll() {
		return session.selectList("itemmapper.selectall");
	}
	
	public ItemVO selectOne(int item_num) {
		return session.selectOne("itemmapper.selectone",item_num);
	}
}
