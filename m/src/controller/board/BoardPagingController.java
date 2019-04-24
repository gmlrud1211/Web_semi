package controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Board;
import service.board.BoardService;
import service.board.BoardServiceImpl;
import util.Paging;

@WebServlet("/board/paging")
public class BoardPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		if(session.getAttribute("login") != null) {
			req.setAttribute("login", true);
		} else { 
			req.setAttribute("login", false);
		}
		
		//현재 페이지 번호 얻기
		int curPage = boardService.getCurPage(req);
		
		//총 게시글 수 얻기
		int totalCount = boardService.getTotalCount();
		
		//페이지 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		//게시글목록 MODEL로 추가
		List<Board> boardList = boardService.getPagingList(paging);
		req.setAttribute("boardList", boardList);
		
		//페이징객체 MODEL로 추가
		req.setAttribute("paging", paging);
		
		//VIEW지정
		req.getRequestDispatcher("/view/board/paginglist.jsp")
			.forward(req, resp);
	}
}










