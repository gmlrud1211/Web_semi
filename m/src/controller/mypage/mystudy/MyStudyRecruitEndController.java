package controller.mypage.mystudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.mypage.mystudy.MyStudyService;
import service.mypage.mystudy.MyStudyServiceImpl;

@WebServlet("/mypage/mystudy/recruitend")
public class MyStudyRecruitEndController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private  MyStudyService mystudyService = new MyStudyServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String studyno = request.getParameter("study_no");
		int study_no = Integer.parseInt(studyno);
		
		mystudyService.recruitEnd(study_no);
		
		response.sendRedirect("/mypage/mystudy/imade");
		
	}
}
