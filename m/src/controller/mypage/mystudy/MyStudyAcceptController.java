package controller.mypage.mystudy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.mypage.mystudy.MyStudyService;
import service.mypage.mystudy.MyStudyServiceImpl;

@WebServlet("/mypage/mystudy/accept")
public class MyStudyAcceptController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MyStudyService mStudy = new MyStudyServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String uno = request.getParameter("u_no");
		int u_no = Integer.parseInt(uno);
		
		String studyno = request.getParameter("study_no");
		int study_no = Integer.parseInt(studyno);
		
		String type = request.getParameter("type");
		
		if( type.equals("accept")) {
			// 수락인 경우 
			mStudy.memberAccept (u_no, study_no);
		} else {
			// 거절인 경우
			mStudy.memberDecline (u_no, study_no);
		}
		
		response.sendRedirect("/mypage/mystudy/imade");
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
