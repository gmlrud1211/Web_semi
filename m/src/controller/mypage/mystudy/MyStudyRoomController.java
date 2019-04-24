package controller.mypage.mystudy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.mypage.mystudy.MyStudy;
import dao.mypage.mystudy.MyStudyImpl;
import dto.Study;
import service.mypage.mystudy.MyStudyService;
import service.mypage.mystudy.MyStudyServiceImpl;

@WebServlet("/mypage/mystudy/mystudyroom")
public class MyStudyRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MyStudy ms = new MyStudyImpl();
	private MyStudyService msSer = new MyStudyServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		int u_no = (int)session.getAttribute("u_no"); // u_no 받아오기
		
		List<Study> mystudy = msSer.progressStudy(u_no);
		
		session.setAttribute("myStudy", mystudy);
		
		req.getRequestDispatcher("/view/mypage/mystudy/mystudyroom.jsp").forward(req, resp);	
		
	
	}
}
