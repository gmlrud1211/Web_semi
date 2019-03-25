package controller.team;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Achive;
import service.team.TeamService;
import service.team.TeamServiceImpl;


@WebServlet("/team/achive/write")
public class TeamAchiveWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamService teamService = new TeamServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/team/achiveEnroll.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//요청파라미터
		Achive achive = teamService.getParam(req,resp);
				
		//목표 등록
		teamService.InsertAchive(achive);
						
		resp.sendRedirect("/team/manage");		
			
	}

}
