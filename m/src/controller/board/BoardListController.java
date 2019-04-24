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
import dto.Users;
import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private BoardService board = new BoardServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Board> boardList = board.selectAll();
		
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/board/paging").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	}
}