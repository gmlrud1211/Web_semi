package service.team;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.team.TeamDao;
import dao.team.TeamDaoImpl;
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

}
