package controller.admin.oneandboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.NoticeBoard;
import dto.OneAndBoard;
import service.admin.oneandboard.OneAndBoardService;
import service.admin.oneandboard.OneAndBoardServiceImpl;

@WebServlet("/oneandboard/write")
public class OneAndBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OneAndBoardService obService = new OneAndBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 되어있지 않으면 /main으로 리다이렉트
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/users/login"); //리다이렉트
			return; //doGet 중단
		}
		
		//요청파라미터 -> MODEL
		OneAndBoard oboard = obService.getParam(req, resp);
		
		//게시글 조회수행
		OneAndBoard oboardview = obService.view(oboard);
		
		
		
		//MODEL 전달
		req.setAttribute("oboardview", oboardview);

		req.getSession().setAttribute("one_no", oboard.getOne_no());
		
	
		req.getRequestDispatcher("/view/admin/oneandboard/write.jsp")
			.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		

		req.setCharacterEncoding("utf-8");
		
		HttpSession httpsession = req.getSession(true);
		httpsession.getAttribute("one_no");
		System.out.println("sadsaddsdas" + httpsession.getAttribute("one_no"));
		
		
		System.out.println("[WRITE] "+req.getParameter("one_anscontent"));
		System.out.println("[WRITE] "+req.getParameter("one_no"));
		System.out.println("[WRITE] "+req.getParameter("one_status"));
		
	    OneAndBoard oneandboard = new OneAndBoard();
		

	    int one_no = (Integer)httpsession.getAttribute("one_no");
		String one_anscontent = req.getParameter("content");

		System.out.println(one_anscontent);
	 
		oneandboard.setOne_no(one_no);
		oneandboard.setOne_anscontent(one_anscontent);
		
		obService.update(oneandboard);
	
 	    resp.sendRedirect("/oneandboard/list");
	    	
		
		
	}
	
}
















