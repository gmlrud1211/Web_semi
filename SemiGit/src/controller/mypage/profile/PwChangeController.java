package controller.mypage.profile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.users.UsersService;
import service.users.UsersServiceImpl;

@WebServlet("/mypage/profile/pw")
public class PwChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsersService uServ = new UsersServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		
		
	}
}
