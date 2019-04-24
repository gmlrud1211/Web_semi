package dao.admin.board;

import java.util.List;

import dto.Board;
import dto.BoardComment;
import util.Paging;

public interface BoardDao {

	//공지사항 전체 조회
	public List selectAll();

//	// 조회수 증가
//	public void updateCount(NoticeBoard nboardview);
	
	//게시글 상세조회 반환
	public Board selectBoardByBoardno(Board boardview);
	
	//자유게시판 삭제 반환
	public void delectBoardByBoardno(int b_no);
	
	//자유게시판 댓글 삭제 반환
	public void delectBoardCommentByBoardno(int b_no);
	
	//총 게시글 수 반환
	public int selectCntBoard();
	
	//페이징 처리 게시글 반환
	public List selectPaginglist(Paging paging);
	
	
	//게시판 글 검색 후 페이지 반환
	public List<Board> search(String type, String word);
	
}
















