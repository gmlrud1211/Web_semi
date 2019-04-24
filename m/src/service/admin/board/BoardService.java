package service.admin.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.NoticeBoard;
import util.Paging;

public interface BoardService {

	//요청파라미터 데이터를 객체화하여 반환
	public Board getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//게시글 전체 조회
	public List getList();

	
	//게시글 검색 조회
	public List<Board> getSearch(String type, String word);
	
	//게시글 상세 조회
	public Board view(Board boardview);
	
	// 게시글 , 댓글 삭제 
	public void delete(int b_no);

	//요청파라미터에서 curPage 반환
	public int getCurPage(HttpServletRequest req);
	
	//총 게시글 수 얻기
	public int getTotalCount();
	
	//페이징 리스트 얻기
	public List getPagingList(Paging paging);
	
	
	
}

















