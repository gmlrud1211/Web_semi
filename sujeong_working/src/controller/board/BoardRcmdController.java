package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/recommend")
public class BoardRcmdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// 추천인 u_no, 해당 b_no, type(추천/비추천)
		String u_no = "100";
		String b_no = request.getParameter("b_no");
		String type = request.getParameter("type");
		
		 if(type.equals("recommend")) { 
			 // 추천인 경우 
			 boardService.recommend(u_no, b_no);
		 } else if(type.equals("cancel")) { 
			 // 추천취소인 경우
			 boardService.recommendCancel(u_no, b_no); 
		 }
		 
		int count = boardService.getRecommendCnt(b_no);
		response.getWriter().print(count);
	}
}
