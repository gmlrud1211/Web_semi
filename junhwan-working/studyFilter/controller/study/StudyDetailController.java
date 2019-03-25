package controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Bookmark;
import dto.Study;
import service.study.DetailStudyService;
import service.study.DetailStudyServiceImpl;
import service.study.StudyService;
import service.study.StudyServiceImpl;

@WebServlet("/study/detail")
public class StudyDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudyService stuService = new StudyServiceImpl();
	private DetailStudyService detailStudy = new DetailStudyServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		Bookmark bmark = new Bookmark();
		// session true
		HttpSession session = req.getSession(true);
		int u_no = (int) session.getAttribute("u_no"); //세션값 u_no 받아오기
		int study_no = (Integer.parseInt(req.getParameter("study_no")));
		
		boolean isBookmark=detailStudy.getDuplicated(study_no, u_no);
		//신청하기 유효성검사
		boolean isApply = detailStudy.getAppDuplicated(u_no, study_no);
		
		bmark.setU_no(u_no);
		bmark.setStudy_no(study_no);
		
		System.out.println("study detailController : "+study_no);

		//서비스에서 받은 정보 가져와서 studyDetail 변수에 넣어줌
		Study studyDetail = stuService.getStudy(study_no);
		System.out.println(studyDetail);
		// setAttribute로 jsp에서 사용할 attribute생성
		req.setAttribute("studyDetail", studyDetail);
		req.setAttribute("isApply", isApply);
		req.setAttribute("isBookmark", isBookmark);
		System.out.println("DetailIsApplyController : "+isApply);
		// 상세페이지 view 지정
		req.getRequestDispatcher("/view/study/detail.jsp").forward(req, resp);
	}

}
