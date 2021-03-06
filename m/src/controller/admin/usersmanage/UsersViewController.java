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
		
		//요청파라미터 -> MODEL
		Users users = usersService.getParam(req, resp);
		
		//게시글 조회수행
		Users usersview = usersService.view(users);
		
		//MODEL 전달
		req.setAttribute("usersview", usersview);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/usersmanage/view.jsp")
			.forward(req, resp);
		
	}
	
}







