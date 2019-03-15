package service.mypage.myBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.MyBoard;
import utill.Paging;

public interface myBoardService {
	
//	public List getBoardListByUno(int u_no);
	
	public MyBoard getBoardByBno(int b_no);
	
	// 요청파라미터에서 curPage 반환
	public int getCurPage(HttpServletRequest req);
			
	// 총 작성 게시글 수 얻기
	public int getTotalMyBoardCount(int u_no);
	
	// 사용자별 게시글 페이징 리스트 얻기
	public List getMyBoardPagingList(int u_no, Paging paging);
		
	

}
