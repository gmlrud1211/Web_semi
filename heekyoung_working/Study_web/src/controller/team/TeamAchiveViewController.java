package controller.team;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Achive;
import service.team.TeamService;
import service.team.TeamServiceImpl;

@WebServlet("/team/achive/view")
public class TeamAchiveViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamService teamService = new TeamServiceImpl();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Achive achive = new Achive();
		
		//각 목표 조회
		List<Achive> achiveList = teamService.getAchiveList(achive);
		
		request.setAttribute("achive", achive);
		
		request.setAttribute("achiveList", achiveList);
		
				
		request.getRequestDispatcher("/view/team/achiveStatus.jsp").forward(request, response);
	
	}

	
}
