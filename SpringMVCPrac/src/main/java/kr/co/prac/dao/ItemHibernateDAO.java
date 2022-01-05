package kr.co.prac.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.prac.domain.ItemVO;

@Repository
public class ItemHibernateDAO {
	//Hibernate 연동 객체 주입
	@Autowired
	private SessionFactory sessionFactory;
	
	//전체 데이터 가져오기
	public List<ItemVO> selectAll(){
		CriteriaQuery <ItemVO> criteriaQuery = sessionFactory.getCurrentSession()
				.getCriteriaBuilder().createQuery(ItemVO.class);
		criteriaQuery.from(ItemVO.class);
		List<ItemVO> list = sessionFactory.getCurrentSession()
				.createQuery(criteriaQuery).getResultList();
		
		return list;
	}
	
	//기본키를 가지고 하나의 데이터를 가져오기
	public ItemVO selectOne(int item_num) {
		ItemVO itemVO = (ItemVO)sessionFactory.getCurrentSession()
				.get(ItemVO.class, item_num);
		return itemVO;
	}
	
	
	
	
	
	
	
	
}
