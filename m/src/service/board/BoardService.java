package service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.BoardComment;
import util.Paging;

public interface BoardService {
	
	//요청파라미터 데이터를 객체화하여 반환
	public Board getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//게시글 전체 조회
	public List<Board> selectAll();
	
	//게시글 상세 조회
	//	조회된 게시글의 조회수도 증가시킨다
	public Board view(Board boardView);

	//요청파라미터에서 curPage 반환
	public int getCurPage(HttpServletRequest req);
	
	//총 게시글 수 얻기
	public int getTotalCount();
	
	//페이징 리스트 얻기
	public List getPagingList(Paging paging);

	public void recommend(int u_no2, String u_no);

	public List<Board> boardSearch(String type, String keyword);

	// 글 작성
	public void boardWrite(int b_no, Board board);

	// 글 삭제
	public void boardDelete(String b_no);

	// 특정 게시글 가져오기
	public Board getBoard(String b_no);

	// 추천 취소
	public void recommendCancel(int u_no, String b_no);

	// 추천수 가져오기
	public int getRecommendCnt(String b_no);

	// 게시글 신고
	public void boardReport(String b_no, int u_no);

	// 이미 추천한 게시글인지 여부 체크
	public boolean isRcmd(Board board, int u_no);

	// 작성자 u_no 파라미터반환 (본인작성게시글인지 판단위함) 
	public int getUno(Board board);
	
	public int getBoardno();

	public void boardUpdate(Board board);

	public String getFile(Board board);

	public void updateFileBNo(int b_no, int file_no);

	public List<BoardComment> getComment(int b_no);

	public void commentWrite(BoardComment boardcmt);

	public List<Board> getBestBoard();

	public void deleteComment(int cmt_no);

	public void boardcommentUpdate(int bc_no, String content);


}
