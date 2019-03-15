package dao.mypage.myBoard;

import java.util.List;

import dto.MyBoard;
import utill.Paging;

public interface myBoardDao {

//	public List selectBoardListByUno(int u_no);
	
	public MyBoard selectBoardByBno(int b_no);
	
	// 총 작성 게시글 수 반환
	public int cntMyBoard(int u_no);
	
	// 사용자별 작성 게시글 페이징 처리 리스트 반환
	public List selectMyBoardPagingList(int u_no, Paging paging);
	
	
}
