package dao.admin.usersmanage;

import java.util.List;

import dto.NoticeBoard;
import dto.Users;
import util.Paging;

public interface UsersDao {

	//users 전체 조회
	public List selectAll();
	
	//회원 조회 반환
	public Users selectUsersByUsersno(Users usersview);
	
    //회원 삭제 반환
	public boolean deleteUsersByUsersno(Users usersdel);
	
	//총 회원수 반환
	public int selectCntUsers();
	
	//페이징 처리 게시글 반환
	public List selectPaginglist(Paging paging);
	
	// 회원 검색
	public List<Users> search(String type, String word);
	
    
}
















