package controller.mypage.mystudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.StudyTeamState;

//내가 만든 스터디
@WebServlet("/mypage/mystudy/imade")
public class MadeStudyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 신청 상태 정보 담을 객체 선언
		StudyTeamState teamState = new StudyTeamState();
		// u_no 세션으로 받고(로그인 시) , study_no getParameter로 받기
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		
		request.getRequestDispatcher("/view/mypage/mystudy/madeStudyList.jsp").forward(request, response);
		
	}

}
