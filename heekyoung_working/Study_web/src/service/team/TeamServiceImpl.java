package service.team;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.team.TeamDao;
import dao.team.TeamDaoImpl;
import dto.Achive;
import util.Paging;

public class TeamServiceImpl implements TeamService {
	
	private TeamDao teamDao = new TeamDaoImpl();

	@Override
	public int getCurPage(HttpServletRequest req) {
		//요청 파라미터 curPage 받기
		String param = req.getParameter("curPage");

		//null이나 ""이 아니면 int리턴
		if(param!=null && !"".equals(param)) {
			int curPage = Integer.parseInt(param);
			return curPage;
		}
		
		//null이나 ""이면 0으로 반환
		return 0;
	}

	@Override
	public int getTotalCount() {
		return teamDao.selectCntTeamBoard() ;
	}

	@Override
	public List getPagingList(Paging paging) {
		return teamDao.selectPagingList(paging);
	}

	@Override
	public Achive getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		Achive achive = new Achive();
		
		
		//int study_no = Integer.parseInt(req.getParameter("study_no"));
		//int a_no = Integer.parseInt(req.getParameter("a_no"));
		String a_title=(String)req.getParameter("a_title");
		String a_adate=(String)req.getParameter("a_adate");
		String a_ddate=(String)req.getParameter("a_ddate");
		
		//achive.setStudy_no(study_no);
		//achive.setA_no(a_no);
		achive.setA_title(a_title);
		achive.setA_adate(a_adate);
		achive.setA_ddate(a_ddate);
		
		
		return achive;
	}

	@Override
	public Achive InsertAchive(Achive achive) {
		return teamDao.insertAchive(achive);
	}
	
	
}
