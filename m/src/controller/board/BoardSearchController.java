package controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.board.BoardService;
import service.board.BoardServiceImpl;
import util.Paging;

@WebServlet("/board/search")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardService search = new BoardServiceImpl(); 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		
		List<Board> boardList = search.boardSearch(type, keyword);
		
		int curPage = search.getCurPage(request);
		int totalCount = search.getTotalCount();
		Paging paging = new Paging (totalCount, curPage);
		request.setAttribute("boardList", boardList);
		request.setAttribute("paging", paging);

		request.getRequestDispatcher("/view/board/paginglist.jsp?curPage=1").forward(request, response);
	}
}
