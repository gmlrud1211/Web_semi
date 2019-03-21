package controller.team;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AchivePeople;
import service.team.TeamService;
import service.team.TeamServiceImpl;

@WebServlet("/team/achive/chart")
public class TeamAchiveChartViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TeamService teamService = new TeamServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/team/achiveStatus.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터
		AchivePeople achivePeople = teamService.getAchivePeopleParam(req, resp);
		
		
		//각 대목표에 따른 세부목표 개수 카운트
		int subAchiveCnt = teamService.getSubAchiveCnt();
		System.out.println(subAchiveCnt);
		
		//각 유저가 대목표에 따라 달성한 세부목표 개수
		int userAchiveCnt = teamService.getUserSubAchiveCnt(achivePeople);
		System.out.println(userAchiveCnt);
		
		
		
		
		
		

		
		
		
	}

}
