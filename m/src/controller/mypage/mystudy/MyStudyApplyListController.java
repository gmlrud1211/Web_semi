package controller.mypage.mystudy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.StudyTeamState;
import service.mypage.mystudy.MyStudyService;
import service.mypage.mystudy.MyStudyServiceImpl;

//�떊泥��옄由ъ뒪�듃(applylist.jsp)
@WebServlet("/mypage/mystudy/applylist")
public class MyStudyApplyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private  MyStudyService mystudyService = new MyStudyServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String studyno = request.getParameter("study_no");
		int study_no = Integer.parseInt(studyno);
		System.out.println(study_no);
		
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		// 내가 만든 스터디의 신청자 조회
		List <StudyTeamState> applylist = mystudyService.getListStudymember(u_no, study_no);
		
		request.setAttribute("applyl", applylist);
		
		request.getRequestDispatcher("/view/mypage/mystudy/applylist.jsp").forward(request, response);
		
	}

}
