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
import dto.Study;
import dto.StudyTeamState;
import service.mypage.mystudy.MyStudyService;
import service.mypage.mystudy.MyStudyServiceImpl;
import service.study.DetailStudyService;
import service.study.DetailStudyServiceImpl;

//신청한 스터디list
@WebServlet("/mypage/mystudy/apply")
public class AppliedStudyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//mystudyimpl에 mystudylist조회 쿼리있음
	private MyStudyService myStudySer = new MyStudyServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//StudyTeamState teamState = new StudyTeamState();	
		// session true
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no"); //세션값 u_no 받아오기
//		System.out.println(u_no);
//		detailServ.getAppDuplicated(u_no, study_no);
//		//조회 쿼리 불러오기
		List<StudyTeamState> teamState = myStudySer.getListStudyInfo(u_no);
		//셋 어트리뷰트
		request.setAttribute("teamState", teamState);
		
		boolean isApp= false;
		if(teamState.size()==0) {//신청 안했을 떄 
			isApp=true;
			
		}else {//신청했을 떄 
			isApp=false;
		}
		
		request.setAttribute("isApp", isApp);
		request.getRequestDispatcher("/view/mypage/mystudy/appliedStudyList.jsp").forward(request, response);
	}

}
