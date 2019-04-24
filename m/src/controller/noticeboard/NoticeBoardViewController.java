package controller.noticeboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.NoticeBoard;
import service.admin.noticeboard.NoticeBoardService;
import service.admin.noticeboard.NoticeBoardServiceImpl;

@WebServlet("/noticeboard/view")
public class NoticeBoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeBoardService nbService = new NoticeBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��û�Ķ���� -> MODEL
		NoticeBoard nboard = nbService.getParam(req, resp);
		
		//�Խñ� ��ȸ����
		NoticeBoard nboardView = nbService.view(nboard);
		
		//MODEL ����
		req.setAttribute("nboardView", nboardView);
		
		//VIEW����
		req.getRequestDispatcher("/view/noticeboard/view.jsp")
			.forward(req, resp);
		
		  
		
	}
	
}







