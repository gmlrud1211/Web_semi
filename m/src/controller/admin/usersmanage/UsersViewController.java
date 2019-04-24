package controller.admin.usersmanage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Users;
import service.admin.usersmanage.UsersService;
import service.admin.usersmanage.UsersServiceImpl;

@WebServlet("/usersmanage/view")
public class UsersViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsersService usersService = new UsersServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��û�Ķ���� -> MODEL
		Users users = usersService.getParam(req, resp);
		
		//�Խñ� ��ȸ����
		Users usersview = usersService.view(users);
		
		//MODEL ����
		req.setAttribute("usersview", usersview);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/usersmanage/view.jsp")
			.forward(req, resp);
		
	}
	
}







