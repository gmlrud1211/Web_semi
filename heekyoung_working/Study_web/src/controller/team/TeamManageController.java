package controller.team;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserStudy;
import service.team.TeamService;
import service.team.TeamServiceImpl;

@WebServlet("/team/manage")
public class TeamManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamService teamService = new TeamServiceImpl();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//UserStudy-user조회
		List<UserStudy> userStudyList = teamService.getUserStudyList();
		
		//view에 전달
		request.setAttribute("userStudyList", userStudyList);
		
		
		request.getRequestDispatcher("/view/team/teamManage.jsp").forward(request, response);
	}
	
}
