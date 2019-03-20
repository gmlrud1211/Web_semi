package controller.mypage.profile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Users;
import service.users.UsersService;
import service.users.UsersServiceImpl;


@WebServlet("/mypage/profile/pwcheck")
public class PwCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersService uServ = new UsersServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		Users u = uServ.getUserByUno(u_no);
		String u_pw = u.getU_pw();
		
		
		String input_pw = (String)req.getParameter("u_pw");
//		System.out.println("pw"+input_pw);
//		System.out.println("db"+u_pw);
		
//		String res = "비밀번호가 틀립니다. 다시 확인해주세요";
		boolean pass = false;
		
		if((u_pw).equals(input_pw)) {
//			res = "확인되었습니다. 새 비밀번호를 입력해주세요";
			pass = true;
		} 

		resp.getWriter().print(pass);
	}
}
