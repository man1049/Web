package serv;

import java.util.Map;

public class MainDAO {
	//싱글톤을 위한 코드
	private MainDAO() {}
	
	private static MainDAO mdao;
	
	
	public static MainDAO getInstance() {
		if(mdao == null) {
			mdao = new MainDAO();
		}
		return mdao;
	}
	
	//데이터를 삽입하는 메서드
	public int doInsert(Map<String,Object> map) {
		//데이터를 삽입하는 작업
		
		return 1;
	}

}
