package controller.admin.usersmanage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usersmanage/write")
public class UsersWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//�α��� �Ǿ����� ������ /main���� �����̷�Ʈ
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/main"); //�����̷�Ʈ
			return; //doGet �ߴ�
		}
		
		req.getRequestDispatcher("/view/admin/usersmanage/write.jsp")
			.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		System.out.println("[WRITE] "+req.getParameter("title"));
		System.out.println("[WRITE] "+req.getParameter("content"));
	}
	
}
















