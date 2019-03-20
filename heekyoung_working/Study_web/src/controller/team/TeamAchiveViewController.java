package controller.team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Achive;
import dto.AchivePeople;
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
		request.setAttribute("achiveListSize", achiveList==null ?0 :achiveList.size());

		List<String> subANoList = new ArrayList<>();
		for(Achive a : achiveList)	subANoList.add(String.valueOf(a.getSuba_no()));
			
		
		request.setAttribute("subANoList", subANoList.toString());
		
		
		request.getRequestDispatcher("/view/team/achiveStatus.jsp").forward(request, response);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//한글 인코딩
		req.setCharacterEncoding("utf-8");
		
		//요청파라미터
		AchivePeople achivePeople = teamService.getAchivePeopleParam(req, resp);
		

//		teamService.checkSubAchive(achivePeople);

		teamService.checkSubAchive2(achivePeople);

		resp.getWriter().println("\"result\"");
			
//		resp.sendRedirect("/team/achive/view");
	}
	

	
}
