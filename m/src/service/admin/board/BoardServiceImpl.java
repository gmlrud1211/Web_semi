package service.admin.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.board.BoardDao;
import dao.admin.board.BoardDaoImpl;
import dto.Board;
import dto.NoticeBoard;
import util.Paging;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDaoImpl();

	@Override
	public Board getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//요청파라미터 정보를 저장할 DTO객체
		Board board = new Board();
		
		//요청파라미터 받기
		String b_no= req.getParameter("b_no");
		
		//null이나 ""이 아니면 int로 변환하여 DTO에 저장
		if( b_no!= null && !"".equals(b_no) ) {
			board.setB_no(Integer.parseInt(b_no));
		}

		//요청파라미터가 객체로 변환된 DTO 반환
		return board;
	}

	
	
	//board 테이블 전체 조회결과 반환
	@Override
	public List getList() {
		return boardDao.selectAll();
	}

	
	
	//게시글 상세 조회
	
	@Override
	public Board view(Board boardView) {
//		//조회수 증가
//		boardDao.updateCount(boardView);
		
		//상세글 반환
		return boardDao.selectBoardByBoardno(boardView);
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
		return boardDao.selectCntBoard();
	}

	
	//페이징 리스트 얻기
	@Override
	public List getPagingList(Paging paging) {
		return boardDao.selectPaginglist(paging);
	}



	@Override
	public void delete(int b_no) {
	   boardDao.delectBoardCommentByBoardno(b_no);
       boardDao.delectBoardByBoardno(b_no);
	}



	@Override
	public List<Board> getSearch(String type, String word) {
		
		return boardDao.search(type, word);
	}



	

}

















