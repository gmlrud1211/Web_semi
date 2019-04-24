package controller.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.users.UsersService;
import service.users.UsersServiceImpl;

@WebServlet("/users/duplication")
public class UsersIdDupController extends HttpServlet {

	private UsersService usersService = new UsersServiceImpl();
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("u_id");
		boolean isDupId = usersService.dupId(userId);
		response.getWriter().print(isDupId);
	}
}
