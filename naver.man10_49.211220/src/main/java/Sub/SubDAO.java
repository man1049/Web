package Sub;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DAO;

public class SubDAO extends DAO{
	//싱글톤(인스턴스를 하나만 만들 수 있도록 클래스를 디자인 하는 것)
	//서버에서 작업을 수행하는 클래스나 공유 데이터를 소유하는 클래스
	//또는 Entry Point가 되는 클래스를 싱글톤으로 디자인합니다.

	private SubDAO() {
		connect();
	}
	
	private static SubDAO sdao;
	
	public static SubDAO getInstance() {
		if(sdao == null) {
			sdao = new SubDAO();
		}
		return sdao;
	}
	
	public List<Sub> getList() {
		List<Sub> list = new ArrayList<>();
		try {
			
			pstmt = con.prepareStatement("select * from Subject");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sub sub = new Sub();
				sub.setCode(rs.getInt("code"));
				sub.setCategory(rs.getString("category"));
				sub.setDescription(rs.getString("description"));
				sub.setTitle(rs.getString("title"));
				list.add(sub);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.print("에러"+e.getLocalizedMessage());
		}
		return list;
	}
	//상세보기를 위한 메서드
	public Sub getInfo(int code) {
		Sub sub = new Sub();
		try {
			pstmt = con.prepareStatement("select * from Subject where code = ?");
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			sub.setCode(rs.getInt("code"));
			sub.setTitle(rs.getString("title"));
			sub.setDescription(rs.getString("description"));
			sub.setCategory(rs.getString("category"));
			}
			pstmt.close();
			rs.close();
			
		} catch (SQLException e) {
			System.out.println("SubDAO error : "+e.getLocalizedMessage());
		}
		return sub;
	}
	//가장 큰 코드를 가져오는 메서드
	public int maxCode() {
		int maxcode = 0;
		try {
			pstmt = con.prepareStatement("select max(code) maxcode from Subject");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				maxcode = rs.getInt("maxcode");
			}
		} catch (SQLException e) {
			System.out.println("SubDAO-maxcode error : "+e.getLocalizedMessage());
		}
		
		return maxcode;
	}
	
	public int insert(Sub sub) {
		int res = 0;
		try {
			
			pstmt = con.prepareStatement("insert into Subject(code,title,category,description) values(?,?,?,?)");
			pstmt.setInt(1, sub.getCode());
			pstmt.setString(2, sub.getTitle());
			pstmt.setString(3, sub.getCategory());
			pstmt.setString(4, sub.getDescription());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.print("SubDAO-Insert error : "+e.getLocalizedMessage());
		}
		return res;
	}
}
