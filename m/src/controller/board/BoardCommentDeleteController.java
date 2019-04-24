package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/commentDelete")
public class BoardCommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardService boardService = new BoardServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comment_no = request.getParameter("cmt_no");
		int cmt_no = Integer.parseInt(comment_no);
		String b_no = request.getParameter("b_no");
		boardService.deleteComment(cmt_no);
				
		response.sendRedirect("/board/detail?b_no=" + b_no);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
