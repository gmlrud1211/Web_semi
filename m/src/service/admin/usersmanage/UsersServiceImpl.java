package service.admin.usersmanage;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.usersmanage.UsersDao;
import dao.admin.usersmanage.UsersDaoImpl;
import dto.Board;
import dto.NoticeBoard;
import dto.Users;
import util.DBConn;
import util.Paging;

public class UsersServiceImpl implements UsersService {

	private UsersDao usersDao = new UsersDaoImpl();

	@Override
	public Users getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//요청파라미터 정보를 저장할 DTO객체
		Users users = new Users();
		
		//요청파라미터 받기
		String u_no = req.getParameter("u_no");
		
		//null이나 ""이 아니면 int로 변환하여 DTO에 저장
		if( u_no!= null && !"".equals(u_no) ) {
			users.setU_no(Integer.parseInt(u_no));
		}

		//요청파라미터가 객체로 변환된 DTO 반환
		return users;
	}

	
	
	//users테이블 전체 조회결과 반환
	@Override
	public List getList() {
		return usersDao.selectAll();
	}

	
	//회원정보 상세 조회
	@Override
	public Users view(Users usersview) {
	
		//상세글 반환
		return usersDao.selectUsersByUsersno(usersview);
	}

	
	//요청파라미터에서 curPage 반환
	@Override
	public int getCurPage(HttpServletRequest req) {
		
		//요청파라미터 curPage 받기
		String param = req.getParameter("curPage");
	
		//null이나 ""이 아니면 int로 리턴
		if( param != null && !"".equals(param) ) {
			int curPage = Integer.parseInt(param);
			return curPage;
		}
		
		//null이나 ""면 0으로 반환하기
		return 0;
	}


	//총 게시글 수 얻기
	@Override
	public int getTotalCount() {
		return usersDao.selectCntUsers();
	}

	
	//페이징 리스트 얻기
	@Override
	public List getPagingList(Paging paging) {
		return usersDao.selectPaginglist(paging);
	}



	@Override
	public boolean delete(Users userdel) {
		
		
		Connection conn = DBConn.getConnection();
		
		//회원삭제 반환
		if ( usersDao.deleteUsersByUsersno(userdel) ){
			//삭제  성공
			
			return  true;
		} else {
			//삭제  실패
			return false;
		}
		
		
		}
	
	@Override
	public List<Users> getSearch(String type, String word) {
		
		return usersDao.search(type, word);
	}
	}



















