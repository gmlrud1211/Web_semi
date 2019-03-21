package service.team;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.team.TeamDao;
import dao.team.TeamDaoImpl;
import dto.Achive;
import dto.AchivePeople;
import dto.UserStudy;
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
	
		//HttpSession session = req.getSession(true);
		//int study_no =  (int)session.getAttribute("study_no");		
		//int study_no = Integer.parseInt(req.getParameter("study_no"));
		//int a_no = Integer.parseInt(req.getParameter("a_no"));
		String a_title=(String)req.getParameter("a_title");
		String a_adate=(String)req.getParameter("a_adate");
		String a_ddate=(String)req.getParameter("a_ddate");
		String suba_name = (String)req.getParameter("suba_name");
		
		//achive.setStudy_no(study_no);
		//achive.setA_no(a_no);
		achive.setA_title(a_title);
		achive.setA_adate(a_adate);
		achive.setA_ddate(a_ddate);
		achive.setSuba_name(suba_name);
		
		
		return achive;
	}

	@Override
	public void InsertAchive(Achive achive) {
		//목표등록, 세부목표등록
		teamDao.insertAchive(achive);
		int a_no = teamDao.getA_no(achive);
		achive.setA_no(a_no);
		teamDao.insertSubAchive(achive);
	}
	

	@Override
	public List getUserStudyList(UserStudy userStudy) {
		//userStudy 조회 결과 반환
		return teamDao.userStudySelectAll(userStudy);
	}

	@Override
	public List getAchiveList(Achive achive) {
		return teamDao.achiveSelectAll(achive);
	}

	@Override
	public AchivePeople getAchivePeopleParam(HttpServletRequest req, HttpServletResponse resp) {

		AchivePeople achivePeople = new AchivePeople();
		
		int suba_no = Integer.parseInt(req.getParameter("suba_no"));
//		String sub_code=(String)req.getParameter("sub_code");
		boolean checked= Boolean.parseBoolean(req.getParameter("checked"));
		
		HttpSession session = req.getSession(true);
		int u_no =  (int)session.getAttribute("u_no");
		
		
		
		achivePeople.setSuba_no(suba_no);
//		achivePeople.setSub_code(sub_code);
		achivePeople.setU_no(u_no);
		achivePeople.setChecked(checked);
		
		System.out.println(achivePeople);
		
		return achivePeople;
	}

	@Override
	public AchivePeople checkSubAchive(AchivePeople achivePeople) {
		teamDao.checkSubAchive(achivePeople);	
		
		return achivePeople;
	}

	@Override
	public void checkSubAchive2(AchivePeople achivePeople) {
		if( achivePeople.isChecked() ) {
			System.out.println("넣고");
			teamDao.insertCheckSubAchive(achivePeople);
		} else {
			System.out.println("빼고");
			teamDao.deleteCheckSubAchive(achivePeople);
		}
	}

	@Override
	public int getSubAchiveCnt() {
		return teamDao.selectSubAchiveCnt();
	}

	@Override
	public int getUserSubAchiveCnt(AchivePeople achivePeople) {
		return teamDao.selectUserSubAchiveCnt(achivePeople);
	}

	
}
