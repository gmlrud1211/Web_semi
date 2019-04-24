package service.admin.usersmanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.NoticeBoard;
import dto.Users;
import util.Paging;

public interface UsersService {

	//요청파라미터 데이터를 객체화하여 반환
	public Users getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//회원 전체 조회
	public List getList();
	
	//회원정보 상세 조회
	public Users view(Users usersview);
	
	//회원 삭제
	public boolean delete(Users userdel);

	//요청파라미터에서 curPage 반환
	public int getCurPage(HttpServletRequest req);
	
	//총 회원 수 얻기
	public int getTotalCount();
	
	//페이징 리스트 얻기
	public List getPagingList(Paging paging);
	
	//회원조회
	public List<Users> getSearch(String type, String word);
}

















