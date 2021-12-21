package Sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SubService {
	//전체 데이터 가져오기
	public void getList(HttpServletRequest request,HttpServletResponse response);
	//하나의 데이터 가져오기
	public void getInfo(HttpServletRequest request,HttpServletResponse response);
	//하나의 데이터 입력하기
	public void setInsert(HttpServletRequest request, HttpServletResponse response);
	//하나의 데이터 삭제하기
	public void setDelete(HttpServletRequest request, HttpServletResponse response);
	//데이터 수정하기
	public void setUpdate(HttpServletRequest request, HttpServletResponse response);
}
