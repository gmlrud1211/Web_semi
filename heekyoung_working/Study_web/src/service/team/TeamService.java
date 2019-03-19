package service.team;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Achive;
import dto.UserStudy;
import util.Paging;

public interface TeamService {

	//curPage 반환
	public int getCurPage(HttpServletRequest req);
	
	//총 게시글 수 얻기
	public int getTotalCount();
		
	//페이징 리스트 얻기
	public List getPagingList(Paging paging);

	
	//요청 파라미터 처리
	public Achive getParam(HttpServletRequest req, HttpServletResponse resp);

	//목표 등록
	public Achive InsertAchive(Achive achive);

	
	//스터디 참여중인 회원 리스트 가져오기
	public List getUserStudyList(UserStudy userStudy);

	
	//목표 리스트 가져오기
	public List getAchiveList(Achive achive);
	
	//목표 번호 가져오기 
	
	
	
}
