package controller.team;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserStudy;
import service.team.TeamService;
import service.team.TeamServiceImpl;

@WebServlet("/team/manage/delete")
public class TeamManageDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamService teamService = new TeamServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserStudy userStudy = new UserStudy();
		
		//스터디원삭제
		boolean userDel = teamService.delete(userStudy);
		
		request.setAttribute("userDel", userDel);		
		
		request.getRequestDispatcher("/view/team/manage.jsp").forward(request, response);
		
	}

}
