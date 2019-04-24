package controller.admin.noticeboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.NoticeBoard;
import service.admin.noticeboard.NoticeBoardService;
import service.admin.noticeboard.NoticeBoardServiceImpl;

@WebServlet("/noticeboard/modify")
public class NoticeBoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeBoardService nbService = new NoticeBoardServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//�α��� �Ǿ����� ������ /main���� �����̷�Ʈ
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/main"); //�����̷�Ʈ
			return; //doGet �ߴ�
		}
		
		  //��û�Ķ���� -> MODEL
	      NoticeBoard nboard = nbService.getParam(req, resp);
				
		  //�Խñ� ��ȸ����
		  NoticeBoard nboardView = nbService.view(nboard);
				
		  //MODEL ����
		  req.setAttribute("nboardView", nboardView);
		  
		  req.getSession().setAttribute("nb_no", nboard.getNb_no());
			
		req.getRequestDispatcher("/view/admin/noticeboard/modify.jsp")
			.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpsession = req.getSession(true);
		httpsession.getAttribute("nb_no");
		System.out.println("sadsaddsdas" + httpsession.getAttribute("nb_no"));
		
		req.setCharacterEncoding("utf-8");

		
		NoticeBoard noticeboard = new NoticeBoard();
		
		
	    int nb_no = (Integer)httpsession.getAttribute("nb_no");
		String nb_title = req.getParameter("title");
		String nb_content = req.getParameter("content");
		
		System.out.println(nb_title);
		System.out.println(nb_content);
		
		noticeboard.setNb_no(nb_no);
		noticeboard.setNb_title(nb_title);
		noticeboard.setNb_content(nb_content);
		
		nbService.update(noticeboard);
		
 	    resp.sendRedirect("/noticeboard/adminlist");
		
	}
	
}
















