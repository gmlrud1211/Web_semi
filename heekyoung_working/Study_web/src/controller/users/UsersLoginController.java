package controller.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.users.UsersDao;
import dao.users.UsersDaoImpl;
import dto.Users;
import service.users.UsersService;
import service.users.UsersServiceImpl;


@WebServlet("/users/login")
public class UsersLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsersDao uDao = new UsersDaoImpl();
	private UsersService uServ = new UsersServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/users/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Users user = uServ.getParam(request, response);
		boolean login = uServ.login(user);
		
		if(login==true) {
			Users u = uServ.getUserByUid(user);

			session.setAttribute("u_no", u.getU_no());
			session.setAttribute("u_id", u.getU_id());
			session.setAttribute("u_name", u.getU_name());

		}
		
		session.setAttribute("login", login);
		response.sendRedirect("/main");
	}

}
