package controller.team;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.StudyBoard;
import util.Paging;
import service.team.TeamService;
import service.team.TeamServiceImpl;

@WebServlet("/team/board")
public class TeamBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamService teamService = new TeamServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//현재 페이지 번호 얻기
		int curPage = teamService.getCurPage(request);
				
		//총게시글 수 얻기
		int totalCount = teamService.getTotalCount();
				
		//페이지 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		List<StudyBoard> boardList = teamService.getPagingList(paging);
		
		request.setAttribute("boardList", boardList);
		
		request.setAttribute("paging", paging);
				
		request.getRequestDispatcher("/view/team/teamboard.jsp").forward(request, response);
		
		
	}
	

}
