package controller.admin.noticeboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.NoticeBoard;
import service.admin.noticeboard.NoticeBoardService;
import service.admin.noticeboard.NoticeBoardServiceImpl;

@WebServlet("/noticeboard/write")
public class NoticeBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeBoardService nbService = new NoticeBoardServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 되어있지 않으면 /main으로 리다이렉트
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/main"); //리다이렉트
			return; //doGet 중단
		}
		
		req.getRequestDispatcher("/view/admin/noticeboard/write.jsp")
			.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("sdahska");
		
		
		req.setCharacterEncoding("utf-8");
		
		NoticeBoard noticeboard = new NoticeBoard();
		
		String nb_title = req.getParameter("title");
		String nb_content = req.getParameter("content");
		System.out.println(nb_title);
		System.out.println(nb_content);
		
		noticeboard.setNb_title(nb_title);
		noticeboard.setNb_content(nb_content);
		
		nbService.insert(noticeboard);
 	    resp.sendRedirect("/noticeboard/adminlist");
		
	}
	
}
















