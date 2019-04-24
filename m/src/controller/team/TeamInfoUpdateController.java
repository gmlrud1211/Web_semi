package controller.team;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Study;
import service.study.StudyService;
import service.study.StudyServiceImpl;
import service.team.TeamService;
import service.team.TeamServiceImpl;

@WebServlet("/team/info/update")
public class TeamInfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamService teamService = new TeamServiceImpl();
	private StudyService studyservice = new StudyServiceImpl();
	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/team/infoUpdate.jsp").forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//Study study = studyservice.getParam(req,resp);
		Study study = teamService.getStudyParam(req, resp);
		
		
		//스터디 번호 구하기
		
		HttpSession session = req.getSession(true);				
		//int study_no = (int)session.getAttribute("study_no");
		
		//스터디 번호 얻기
		study.setStudy_no(1); //study_no 세션으로 넘어오는게 없어서 일단 1
		
		//스터디 정보 업데이트
		teamService.studyUpdate(study);
		
		
		resp.sendRedirect("/team/manage");
			
	}

}
