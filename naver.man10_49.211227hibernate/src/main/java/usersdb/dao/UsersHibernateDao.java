package usersdb.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import usersdb.domain.Users;

@Repository
public class UsersHibernateDao {
	//데이터베이스 연동 프레임워크 사용 인스턴스 주입
	@Autowired
	private SessionFactory sessionFactory;

	//데이터 삽입
	public void insertUsers(Users users) {
		Session session = sessionFactory.getCurrentSession();
		session.save(users);
	}

	//데이터 삭제
	public void deleteUsers(Users users) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(users);
	}

	//모든 데이터 조회
	public List<Users> selectAllHUsers() {
		//CriteriaQuery<Users> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Users.class);
		//criteriaQuery.from(Users.class);
		//List<Users> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
		Session session = sessionFactory.getCurrentSession();
		Query<Users> q = session.createQuery("from Users");  
		List<Users> list = q.list();

		return list;
	}

	//한개의 데이터 조회
	public Users selectOneHUsers(int num) {
		List<Users> list = sessionFactory.getCurrentSession()
				.createSQLQuery("select * from users where num=:num")
				.addEntity(Users.class)
				.setParameter("num", num).list();
		if(list == null || list.size() < 1)
			return null;
		return list.get(0);
	}




}
