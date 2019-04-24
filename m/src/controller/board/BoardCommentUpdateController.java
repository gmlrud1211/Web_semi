package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/commentupdate")
public class BoardCommentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BoardService boardservice = new BoardServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String parent_reply = request.getParameter("parent_reply");
		int bc_no = Integer.parseInt(parent_reply);
		String content = request.getParameter("content");
		String b_no = request.getParameter("b_no");
		
		boardservice.boardcommentUpdate(bc_no, content);
		
		response.sendRedirect("/board/detail?b_no=" + b_no);
	}
}
