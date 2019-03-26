package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardComment;
import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/comment")
public class BoardCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BoardService boardservice = new BoardServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		BoardComment boardcmt = new BoardComment();
		
		String uno = request.getParameter("u_no");
		String bno = request.getParameter("b_no");
		int u_no = Integer.parseInt(uno);
		int b_no = Integer.parseInt(bno);
		String bc_comment = request.getParameter("content");
		
		boardcmt.setU_no(u_no);
		boardcmt.setB_no(b_no);
		boardcmt.setBc_comment(bc_comment);
		
		if(request.getParameter("parent_reply") != null) {
			String parent_reply = request.getParameter("parent_reply");
			int parent = Integer.parseInt(parent_reply);
			boardcmt.setBc_reno(parent);
		} else {
			boardcmt.setBc_reno(0);
		}
		
		boardcmt.setU_no(u_no);
		boardcmt.setB_no(b_no);
		boardcmt.setBc_comment(bc_comment);
		
		boardservice.commentWrite(boardcmt);
		
		response.sendRedirect("/board/detail?b_no=" + b_no);
	}
}
