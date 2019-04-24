package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/report")
public class BoardReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String b_no = request.getParameter("b_no");
		
		
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		request.setAttribute("u_no", u_no);

		boardService.boardReport(b_no, u_no);
		
		response.sendRedirect("/board/list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
