package controller.mypage.mystudy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import dto.StudyTeamState;
import service.mypage.mystudy.MyStudyService;
import service.mypage.mystudy.MyStudyServiceImpl;
import service.study.DetailStudyService;
import service.study.DetailStudyServiceImpl;

@WebServlet("/mypage/mystudy/insert")
public class MyStudyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MyStudyService sServ = new MyStudyServiceImpl();
	private DetailStudyService detailStudy = new DetailStudyServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 신청 상태 정보 담을 객체 선언
		StudyTeamState teamState = new StudyTeamState();
		// u_no 세션으로 받고(로그인 시) , study_no getParameter로 받기
		HttpSession session = req.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		int study_no = (Integer.parseInt(req.getParameter("study_no")));

		boolean isApply = detailStudy.getAppDuplicated(u_no, study_no);

		teamState.setU_no(u_no);
		teamState.setStudy_no(study_no);
		
//		System.out.println("MyStudyInsertController 유저넘: "+u_no);
//		System.out.println("MyStudyInsertController 스터디넘: "+study_no);
		
		// detail페이지에서 이 컨트롤러로 정보 전송
		if (isApply)
			// 신청했을 때
			sServ.insertMyStudyList(teamState);
			String alert = "신청하기 완료!!";
			String comment1 = "신청완료";
			@SuppressWarnings("deprecation")
			JSONObject obj = new JSONObject();
			obj.put("apply", alert);
			obj.put("comment1", comment1);

			resp.setContentType("application/x-json; charset=UTF-8");
			resp.getWriter().print(obj);	
		
			System.out.println("MyStudyInsertController isApply: "+isApply);
		
	}
}
