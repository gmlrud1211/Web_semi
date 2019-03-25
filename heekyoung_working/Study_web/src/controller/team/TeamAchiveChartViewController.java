package controller.team;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Achive;
import dto.AchivePeople;
import service.team.TeamService;
import service.team.TeamServiceImpl;

@WebServlet("/team/achive/chart")
public class TeamAchiveChartViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TeamService teamService = new TeamServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Achive achive = teamService.getParam(request, response);
		HttpSession session = request.getSession(true);
		int u_no =  (int)session.getAttribute("u_no");
			
		achive.setU_no(u_no);
				
		//각 대목표에 따른 세부목표 개수 카운트
		int subAchiveCnt = teamService.getSubAchiveCnt();
		System.out.println("세부목표갯수 "+subAchiveCnt+"개");
				
		//각 유저가 대목표에 따라 달성한 세부목표 개수
		int userAchiveCnt = teamService.getUserSubAchiveCnt(achive);
		System.out.println(u_no+"의 달성 세부목표"+userAchiveCnt+"개");

		
		request.getRequestDispatcher("/view/team/achiveStatus.jsp").forward(request, response);

	}

}
