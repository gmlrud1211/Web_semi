package service.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;
import dao.board.BoardDaoImpl;
import dto.Board;
import dto.BoardComment;
import util.DBConn;
import util.Paging;

public class BoardServiceImpl implements BoardService {

	private Connection conn = DBConn.getConnection(); 
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public List<Board> selectAll() {
		return boardDao.selectAll();	
	}

	@Override
	public Board getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//요청파라미터 정보를 저장할 DTO객체
		Board board = new Board();
		
		//요청파라미터 받기
		String boardno = req.getParameter("b_no");
		//null이나 ""이 아니면 int로 변환하여 DTO에 저장
		if( boardno != null && !"".equals(boardno) ) {
			board.setB_no(Integer.parseInt(boardno));
		}

		//요청파라미터가 객체로 변환된 DTO 반환
		return board;
	}
	
	@Override
	public int getUno(Board board) {
		int u_no = boardDao.getUno(board);
		return u_no;
	}

	@Override
	public Board view(Board boardView) {
		//조회수 증가
		boardDao.updateHit(boardView);
		//상세글 반환
		return boardDao.selectBoardByBoardno(boardView);
	}

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

	@Override
	public int getTotalCount() {
		return boardDao.selectCntBoard();
	}

	@Override
	public List getPagingList(Paging paging) {
		return boardDao.selectPaginglist(paging);
	}

	@Override
	public void recommend(int u_no, String b_no) {
		boardDao.brdRecommend(b_no);
		boardDao.rcmdUpdate(b_no, u_no);
	}
	
	@Override
	public void recommendCancel(int u_no, String b_no) {
		boardDao.brdRecommendCancel(b_no);
		boardDao.rcmdUpdateCancel(b_no, u_no);
	}
	
	@Override
	public int getRecommendCnt(String b_no) {
		return boardDao.getRecommendCnt(b_no);
	}
	@Override
	public List<Board> boardSearch(String type, String keyword) {
		return boardDao.boardSearch(type, keyword);
	}

	@Override
	public void boardWrite(int b_no, Board board) {
		boardDao.boardWrite(b_no, board);
	}

	@Override
	public void boardDelete(String b_no) {
		boardDao.rcmdUpdateCancel(b_no);
		boardDao.boardDelete(b_no);
	}

	@Override
	public Board getBoard(String b_no) {
		return boardDao.getBoard(b_no);
	}

	@Override
	public void boardReport(String b_no, int u_no) {
		boardDao.boardReport(b_no, u_no);
	}

	@Override
	public boolean isRcmd(Board board, int u_no) {
		boolean result = boardDao.isRcmd(board, u_no);
		return result;
		
	}

	@Override
	public void boardUpdate(Board board) {
		boardDao.boardUpdate(board);
	}

	@Override
	public String getFile(Board board) {
		return boardDao.getFileName(board.getB_no());
	}

	@Override
	public void updateFileBNo(int b_no, int file_no) {
		boardDao.updateFileBNo(b_no, file_no);
	}

	@Override
	public int getBoardno() {
		return boardDao.getBoardno();
	}

	@Override
	public List<BoardComment> getComment(int b_no) {
		return boardDao.getComment(b_no);
	}

	@Override
	public void commentWrite(BoardComment boardcmt) {
		boardDao.commentWrite(boardcmt);
	}

	@Override
	public List<Board> getBestBoard() {
		return boardDao.getBestBoard();
	}

	@Override
	public void deleteComment(int cmt_no) {
		boardDao.deleteComment(cmt_no);
	}

	@Override
	public void boardcommentUpdate(int bc_no, String content) {
		boardDao.commentUpdate(bc_no, content);
	}
}


















