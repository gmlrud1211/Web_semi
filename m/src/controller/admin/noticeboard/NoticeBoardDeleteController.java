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

@WebServlet("/noticeboard/delete")
public class NoticeBoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeBoardService nboardService = new NoticeBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터 -> MODEL
		NoticeBoard nboard = nboardService.getParam(req, resp);
		
		//공지사항 삭제 수행
		int nboarddel = nboardService.delete(nboard);
		
		//MODEL 전달
		req.setAttribute("nboarddel", nboarddel);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/noticeboard/delete.jsp")
			.forward(req, resp);
		
	}
	
}







