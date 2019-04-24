package controller.mypage.mystudy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.mypage.mystudy.MyStudy;
import dto.StudyTeamState;
import service.mypage.mystudy.MyStudyService;
import service.mypage.mystudy.MyStudyServiceImpl;

//MyStudyService에서 delete 메소드 받아서 버튼 눌렀을 시 해당 신청 스터디 삭제 되게 처리할 것
@WebServlet("/mypage/mystudy/delete")
public class MyStudyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MyStudyService mystuServ = new MyStudyServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 신청 상태 정보 담을 객체 선언
		StudyTeamState teamState = new StudyTeamState();
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		int study_no = (Integer.parseInt(request.getParameter("study_no")));


		mystuServ.deletMyStudyList(study_no,u_no);
		response.sendRedirect("/mypage/mystudy/apply");
	}

}
