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


@WebServlet("/board/paginglist")
public class BoardPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	BoardService boardlist = new BoardServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		boolean login = false;
		if(session.getAttribute("login") != null) {
			login = (boolean) session.getAttribute("login");
		} else {
			login = false;
		}
		request.setAttribute("login", login);
		
		// 현재 페이지 번호 얻기
		int curPage = boardlist.getCurPage(request);
		
		int totalCount = boardlist.getTotalCount();
		
		Paging paging = new Paging (totalCount, curPage);
		
		List<Board> boardList = boardlist.getPagingList(paging);
		request.setAttribute("boardList", boardList);
		
		request.setAttribute("paging", paging);
		
		//VIEW지정
		request.getRequestDispatcher("/view/board/paginglist.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
